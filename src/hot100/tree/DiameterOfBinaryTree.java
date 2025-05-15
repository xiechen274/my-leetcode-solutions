package hot100.tree;

import hot100.TreeNode;


/**
 * @author xlj
 * @date 2025-05-13
 * @description 二叉树的直径
 */

public class DiameterOfBinaryTree {

    private static int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        //基本情况
        if(root == null){
            return 0; //基本情况直接返回最小的
        }
        int lLen = dfs(root.left);
        int rLen = dfs(root.right);

        //递归更新最大距离
        ans = Math.max(ans,lLen + rLen);
        return Math.max(lLen,rLen) + 1; //每次基本的都是要+1
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // 用例 1：给定树 [1,2,3,4,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        int result1 = solution.diameterOfBinaryTree(root1);
        System.out.println("Test Case 1: " + result1); // 预期: 1

    }

}
