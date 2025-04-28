package hot100;

import java.util.Arrays;

/**
 *  缺失的第一个正数
 * @author edawrd
 * @version 1.0
 * @date 2025-04-28
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        //如果全部都是复数直接返回1
        if (nums[nums.length - 1] <= 0) {
            return 1;
        }
        int index = 0;
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                index = i;
                break;
            }
        }
        //从正数区间开始遍历
        if(index - 1 >= 0){
            nums[index - 1] = 0;
        }
        int tar = 0;
        for(int i = index; i < nums.length; i++){
            //判断是否起点大于0
            if (index != 0) {
                if(nums[i] - nums[i - 1] > 1){
                    ret =  nums[i - 1] + 1;
                    return ret;
                }
            }else{
                if(nums[i] - tar > 1){
                    ret =  tar + 1;
                    return ret;
                }
            }
            tar = nums[i];
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
