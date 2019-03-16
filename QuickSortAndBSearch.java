import java.util.Arrays;

public class QuickSortAndBSearch {

    public static void main(String[] args) {
        int n = 100;
        int [] a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = (int)(Math.random()*n);
        }
        System.out.println(Arrays.toString(a));
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

        //需查找的值
        int value = 90;
        int result = bsearch(a,value);
        int result1 = bsearchBack(a,0,a.length-1,value);
        System.out.println(result+"\t"+result1);
    }

    private static int bsearchBack(int[] A, int lower, int hight, int value) {
        if(lower > hight) return -1;
        int mid = lower + ((hight - lower)>>1);
        if(A[mid] == value ) return mid;
        else if(A[mid] > value)
            return bsearchBack(A,lower,mid-1,value);
        else
            return bsearchBack(A,mid + 1,hight,value);

    }

    private static int bsearch(int[] A, int value) {
        int len  = A.length;

        int low = 0;
        int hight = len - 1;

        // 注意是 <=
        while(low <= hight){
            // 避免溢出
            int mid = low + ((hight - low)>>1);
            if(A[mid] == value){
                return mid;
            }else if(A[mid] < value){
                //low hight 这两个需要变化 小心死循环
                low = mid + 1;
            }else
                hight = mid - 1;


        }
        return -1;
    }

    private static void quickSort(int[] A, int p, int r) {
        if(p >= r)
            return;
        // 获取分区点
        int q = partition(A, p, r);
        // q 作为中间
        quickSort(A,p,q-1);
        quickSort(A,q+1,r);

    }

    private static int partition(int[] A, int p, int r) {
        //以最后一个为 标记
        int pivot = A[r];
        int i = p;
        // i 之前的（不包括i） 都是小于 pivot的
        // j -> 走 i看情况 跟着走 if j指向的小于 pivot 要么交换 要么 （开始的时候）两个是指的 是同一个
        for(int j = p;j<r;j++){
            if(A[j] < pivot){
                // 这里的 i==j 可以不要 有的话 当 前面的数小于 pivot 时
                // 可以减少 交换次数 但是 会不会划不来 每次都yao比较
                if( i == j){
                    i++;
                }else{
                  //  交换 交换后也要i++
                    int temp = A[i];
                    A[i++] = A[j];
                    A[j] = temp;
                }
            }
        }
       // a[i] 是大于 pivot
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;

        return i;


    }


}
