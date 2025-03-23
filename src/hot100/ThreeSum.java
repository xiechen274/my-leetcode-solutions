package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0,0,0,0};
        //打印threeSum
        List<List<Integer>> lists = threeSum.threeSum(nums);
        lists.stream().forEach(System.out::println);

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;

        // 边界检查：长度小于 3，无法组成三元组
        if (n < 3) {
            return ret;
        }
        // 步骤1：排序
        Arrays.sort(nums);
        // 提前终止：如果第一个元素大于 0三数之和不可能为 0
        if (nums[0] > 0) {
            return ret;
        }
        for (int i = 0; i < n - 2; i++) {
            // 去重：跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义左右指针
            int left = i + 1;
            int right = n - 1;
            int twoSum = 0 - nums[i];

            // 双指针寻找
            while (right > left) {
                int sum = nums[left] + nums[right];
                if (sum == twoSum) {
                    // 找到一个三元组，直接加入结果（无需 contains 检查）
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重：跳过重复的 nums[left] 和 nums[right]
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    // 移动指针
                    left++;
                    right--;
                } else if (sum < twoSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ret;
    }
}
