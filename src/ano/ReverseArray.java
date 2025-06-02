package ano;

import java.util.Arrays;

/**
 * @author xlj
 * @date 2025-06-02
 * @description 这里是自动生成的文件注释
 */

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] reverseArray(int[] arr){
        int head = 0;
        int tail = arr.length - 1;
        while(head < tail) {
            int temp = arr[tail];
            arr[tail--] = arr[head];
            arr[head++] = temp;
        }
        return arr;
    }
}
