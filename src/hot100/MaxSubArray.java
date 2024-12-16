package hot100;

/**
 * @author xlj 2024-12-15
 */

/**
 * LeetCode 53: ����������
 * ��Ŀ����: https://leetcode.cn/problems/maximum-subarray/
 *
 * ��Ŀ����:
 * ����һ���������� nums�������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 *
 * ʾ��:
 * ����: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 *
 * ��ʾ:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
import java.util.Arrays;

public class MaxSubArray {

    /**
     * �����������������ķ���
     * @param nums ��������
     * @return ��������������
     */
    public static int maxSubArray(int[] nums) {
// ��ʼ�������뵱ǰ�������
        int maxSum = nums[0];
        int currentSum = nums[0];

        // �������飬�ӵ�2��Ԫ�ؿ�ʼ
        for (int i = 1; i < nums.length; i++) {
            // ״̬ת�Ʒ���: �ж��Ƿ�Ҫ��ǰ�������������
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            // ��������
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;     
    }

    /**
     * ������������
     * �ṩ���ʾ�����ԣ���֤������ȷ�ԡ�
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

        System.out.println("���в�������...");

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expected = expectedOutputs[i];
            int result = maxSubArray(testCase);

            System.out.println("�������� " + (i + 1) + ": ���� = " + Arrays.toString(testCase));
            System.out.println("Ԥ�����: " + expected + ", ʵ�����: " + result);
            System.out.println(result == expected ? "? ����ͨ��" : "? ����ʧ��");
            System.out.println("--------------------------");
        }
    }

    /**
     * ���������
     */
    public static void main(String[] args) {
        runTests();
    }
}

