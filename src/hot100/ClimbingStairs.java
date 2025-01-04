package hot100;

/**
 * @author xlj 2024-12-16
 */
// File: ClimbingStairs.java

/**
 * LeetCode 70: ��¥��
 * ��Ŀ����: https://leetcode.cn/problems/climbing-stairs/
 *
 * ��Ŀ����:
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥����
 *
 * ʾ��:
 * ����: n = 2
 * ���: 2
 * ����: �����ַ�����������¥����
 * 1. 1 �� + 1 ��
 * 2. 2 ��
 *
 * ����: n = 3
 * ���: 3
 * ����: �����ַ�����������¥����
 * 1. 1 �� + 1 �� + 1 ��
 * 2. 1 �� + 2 ��
 * 3. 2 �� + 1 ��
 *
 * ��ʾ:
 * 1 <= n <= 45
 */

public class ClimbingStairs {

    /**
     * ��¥�ݵķ���
     * @param n ¥�ݵĽ���
     * @return ����¥���ķ�����
     */
    public static int climbStairs(int n) {
        // ���������д��Ĵ�
        return 0; // ��ʱ����ֵ���滻������߼�
    }

    /**
     * ������������
     */
    public static void runTests() {
        int[] testCases = {1, 2, 3, 4, 5, 10};
        int[] expectedOutputs = {1, 2, 3, 5, 8, 89};

        System.out.println("���в�������...");

        for (int i = 0; i < testCases.length; i++) {
            int testCase = testCases[i];
            int expected = expectedOutputs[i];

            System.out.println("�������� " + (i + 1) + ": ���� = " + testCase);
            int result = climbStairs(testCase);

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
