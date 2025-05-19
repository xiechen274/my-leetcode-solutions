package hot100.tree;

import hot100.TreeNode;

/**
 * @author xlj
 * @date 2025-05-18
 * @description 验证二叉搜索树
 */

public class IsValidBST {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        //基本情况
        if(root == null){
            return true;
        }
        //递归处理左子树
        boolean left = isValidBST(root.left);
        if(left == false){
            return false;
        }
        //处理中间节点
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        //最后直接处理右子树情况
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(2,null,null);
        TreeNode right = new TreeNode(2,null,null);

        TreeNode root = new TreeNode(2,right,leftNode);
        IsValidBST isValidBST = new IsValidBST() ;
        boolean validBST = isValidBST.isValidBST(root);

        System.out.printf(String.valueOf(validBST));


    }
}
