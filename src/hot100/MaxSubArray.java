package hot100;

/**
 * @author xlj 2024-12-15
 */

/**
 * LeetCode 53: 最大子数组和
 * 题目链接: https://leetcode.cn/problems/maximum-subarray/
 *
 * 题目描述:
 * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 *
 * 提示:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
import java.util.Arrays;

public class MaxSubArray {

    /**
     * 解决最大子数组和问题的方法
     * @param nums 整数数组
     * @return 最大连续子数组和
     */
    public static int maxSubArray(int[] nums) {
// 初始化最大和与当前子数组和
        int maxSum = nums[0];
        int currentSum = nums[0];

        // 遍历数组，从第2个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程: 判断是否要与前面的子数组连接
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            // 更新最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;     
    }

    /**
     * 测试用例方法
     * 提供多个示例测试，验证程序正确性。
     */
    public static void runTests() {
        int[][] testCases = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8},
                {-1, -2, -3, -4},
                {0, 0, 0, 0}
        };

        int[] expectedOutputs = {6, 1, 23, -1, 0};

        System.out.println("运行测试用例...");

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expected = expectedOutputs[i];
            int result = maxSubArray(testCase);

            System.out.println("测试用例 " + (i + 1) + ": 输入 = " + Arrays.toString(testCase));
            System.out.println("预期输出: " + expected + ", 实际输出: " + result);
            System.out.println(result == expected ? "? 测试通过" : "? 测试失败");
            System.out.println("--------------------------");
        }
    }

    /**
     * 主程序入口
     */
    public static void main(String[] args) {
        runTests();
    }
}

