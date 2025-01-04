import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author xlj 2025-01-04
 * https://www.luogu.com.cn/problem/P1177
 * acm风格
 */
public class MergeSort {
    //递归写法
    public static int MAXN = 10001;

    public static int[] arr = new int[MAXN];

    public  static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        //nval默认返回的是double
        n = (int) in.nval; //读取数组长度
        for(int i = 0; i < n; i++){
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        mergeSortByRecursion(0, n - 1);
        //输出排序后的数组
        for(int i = 0; i < n - 1; i++){
            out.print(arr[i] + " ");
        }
        out.print(arr[n - 1]);
        //关闭流
        out.flush();
        out.close();
        br.close();
    }

    //由于定义静态变量所以不需要传入数组
    private static void mergeSortByRecursion(int l, int r) {
        if(l == r){
            return;
        }
        int mid = (l + r) / 2;
        //排序左右边
        mergeSortByRecursion(l, mid);
        mergeSortByRecursion(mid + 1, r);
        //归并
        merge(l, mid, r);

    }

    private static void merge(int l, int mid, int r) {
        int pointL = l;
        int pointR = mid + 1;
        int index = l; //help数组的下标

        //移动左右区间的指针开始归并
        while(pointL <= mid && pointR <= r){
            //如果相等的话就取左边的，保证稳定性
            help[index++] = arr[pointL] <= arr[pointR] ? arr[pointL++] : arr[pointR++];//谁小取谁
        }
        //将剩余的数放入help数组中
        while(pointL <= mid){
            help[index++] = arr[pointL++];
        }
        while(pointR <= r){
            help[index++] = arr[pointR++];
        }
        for(int i = l; i <= r; i++){
            arr[i] = help[i];
        }
    }

}
