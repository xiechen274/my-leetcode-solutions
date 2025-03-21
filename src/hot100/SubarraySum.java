package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edward
 * @description 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @date 2025/3/21
 */

public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        //构造测试用例
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum.subarraySum(nums,k));

        //额外测试用例1 2 4
        int[] nums2 = {1,2,3};
        System.out.println(subarraySum.subarraySum(nums2, 3));
    }
    public int subarraySum(int[] nums, int k) {
        //用哈希表存储前缀和和出现的次数
        Map<Integer,Integer> preSum = new HashMap<>();
        //0默认在前缀和里面
        preSum.put(0,1);
        int sum = 0;
        int ret = 0;
        //存储前缀和
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            //如果存在sum-k的前缀和，则说明存在子数组
            if(preSum.containsKey(sum - k)){
                ret += preSum.get(sum - k);
            }
            //更新前缀和
            preSum.put(sum,preSum.getOrDefault(sum,0) + 1);
        }

        return ret;
    }
}
