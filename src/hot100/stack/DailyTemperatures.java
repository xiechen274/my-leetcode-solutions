package hot100.stack;

/**
 * @author xlj
 * @date 2025-05-09
 * @description 每日温度
 */

public class DailyTemperatures {

    public int[] dailyTemperatures1(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[]{0};
        }
        int[] retArr = new int[temperatures.length];
        //双重循环遍历
        for(int i = 0; i < temperatures.length - 1; i++){
            int j = i + 1;
            while(j < temperatures.length && temperatures[i] - temperatures[j] >= 0){
                j++;
            }
            //判断是否存在;
            if(j == temperatures.length){
                retArr[i] = 0;
            }else {
                retArr[i] = j - i;
            }
        }
        return retArr;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] arr = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] ints = dailyTemperatures.dailyTemperatures1(arr);
        for (int i : ints){
            System.out.print(i);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[]{0};
        }
        int[] retArr = new int[temperatures.length];

        return retArr;
    }
}
