package hot100;

/**
 * @author edward
 * @description 求二叉树最大深度
 * @date 2025/3/29
 */

public class MaxDepth {
    public static void main(String[] args) {
        //构造用例
        MaxDepth maxDepth = new MaxDepth();


    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int depth = Math.max(leftHeight,rightHeight) + 1;
        return depth;
    }
}
