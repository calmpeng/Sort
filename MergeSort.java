import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int n = 100;
        int [] a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = (int)(Math.random()*n);
        }

        System.out.println(Arrays.toString(a));
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] A,int p ,int r){
        /*归并排序是建立在归并操作上的一种有效的排序算法。
        该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
        将已有序的子序列合并，得到完全有序的序列；
        即先使每个子序列有序，再使子序列段间有序

        算法描述:
        把长度为n的输入序列分成两个长度为n/2的子序列；
        对这两个子序列分别采用归并排序；
        将两个排序好的子序列合并成一个最终的排序序列。
                    * */
        if(p >= r)
            return ;
        //防止 （r+p）溢出
        int q = p + (r - p)/2;

        mergeSort(A,p,q);
        mergeSort(A,q+1,r);

        merge(A,p,q,r);


    }

    private static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;

        int []temp = new int[r-p+1];
        int index = 0;
        while(i <=q && j <=r){
            // 需要 <= 等于号保证 稳定性
            if(A[i] <= A[j]){
                temp[index++] = A[i];
                i++;
            }else{
                temp[index++] = A[j];
                j++;
            }
        }

        //判断那边有剩余 只有一边有剩余 或者 都没有, 先假定是 第一部分 有剩余
        int start = i;
        int end = q;

        // 看是不是 第二部分 有剩余
        if(j <= r){
            start = j;
            end = r;
        }



        //剩余部分拷贝
        while(start <= end){
            temp[index++]  = A[start++];
        }

        //将临时的数组拷贝到 A的（p，r）中
        for( i = 0;i<r-p+1;i++){
            A[p+i] = temp[i];
        }
    }

}
