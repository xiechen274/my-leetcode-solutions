import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author xlj 2025-01-05
 * 小和问题
 * 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
 */
public class SmallSum {
    public static int MAXN = 100000;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        //处理输入输出
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        out.println(smallSum(0, n - 1));

        out.flush();
        out.close();
    }
    //计算小和
    private static long smallSum(int l, int r) {
        if(l == r){
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l, m) + smallSum(m + 1, r) + mergeAndSum(l, m, r);

    }

    //统计并且并且排序
    private static long mergeAndSum(int l, int m, int r) {
        int lPoint = l;
        int rPoint = m + 1;
        long tempSum = 0;
        long ans = 0;
        //滑动窗口统计
        for(int i = m + 1, j = l; i <= r; i++){
            //不超过左侧窗口指针，并且符合小和的统计条件
            while(j <= m && arr[j] <= arr[i]){
                tempSum += arr[j++];
            }
            ans += tempSum;
        }
        //归并
        int helpLPoint = l;
        while(lPoint <= m && rPoint <= r){
            help[helpLPoint++] = arr[lPoint] <= arr[rPoint] ? arr[lPoint++] : arr[rPoint++];
        }
        while(lPoint <= m){
            help[helpLPoint++] = arr[lPoint++];
        }
        while(rPoint <= r){
            help[helpLPoint++] = arr[rPoint++];
        }
        for(int i = l; i <= r; i++){
            arr[i] = help[i];
        }
        return ans;
    }

}
