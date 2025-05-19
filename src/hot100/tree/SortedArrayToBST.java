package hot100.tree;

import hot100.TreeNode;

/**
 * @author xlj
 * @date 2025-05-15
 * @description 将有序数组转换为二叉搜索树
 */

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        //基本情况
        if(left > right) return null;
        int mid = left + (right - left) / 2; //使用偏移量的方式来计算mid距离
        TreeNode root = new TreeNode(nums[mid]);

        //递归处理
        root.left = buildBST(nums,left,mid - 1);
        root.right = buildBST(nums,mid + 1,right);
        return root;
    }

    // 本地测试方法
    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();

        // 用例 1：标准数组
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode result1 = solution.sortedArrayToBST(nums1);
        System.out.println("Test Case 1: " + result1); // 预期: [0,-10,5,null,-3,null,9]

        // 用例 2：空数组
        int[] nums2 = {};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        System.out.println("Test Case 2: " + result2); // 预期: []

        // 用例 3：单元素
        int[] nums3 = {1};
        TreeNode result3 = solution.sortedArrayToBST(nums3);
        System.out.println("Test Case 3: " + result3); // 预期: [1]

        // 用例 4：两个元素
        int[] nums4 = {1, 3};
        TreeNode result4 = solution.sortedArrayToBST(nums4);
        System.out.println("Test Case 4: " + result4); // 预期: [1,null,3]
    }


}
