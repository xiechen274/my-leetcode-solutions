package hot100;

/**
 * @author xlj 2024-12-16
 */
// File: ClimbingStairs.java

/**
 * LeetCode 70: 爬楼梯
 * 题目链接: https://leetcode.cn/problems/climbing-stairs/
 *
 * 题目描述:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶？
 *
 * 示例:
 * 输入: n = 2
 * 输出: 2
 * 解释: 有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 输入: n = 3
 * 输出: 3
 * 解释: 有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示:
 * 1 <= n <= 45
 */

public class ClimbingStairs {

    /**
     * 爬楼梯的方法
     * @param n 楼梯的阶数
     * @return 到达楼顶的方法数
     */
    public static int climbStairs(int n) {
        // 请在这里编写你的答案
        return 0; // 临时返回值，替换成你的逻辑
    }

    /**
     * 测试用例方法
     */
    public static void runTests() {
        int[] testCases = {1, 2, 3, 4, 5, 10};
        int[] expectedOutputs = {1, 2, 3, 5, 8, 89};

        System.out.println("运行测试用例...");

        for (int i = 0; i < testCases.length; i++) {
            int testCase = testCases[i];
            int expected = expectedOutputs[i];

            System.out.println("测试用例 " + (i + 1) + ": 输入 = " + testCase);
            int result = climbStairs(testCase);

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
