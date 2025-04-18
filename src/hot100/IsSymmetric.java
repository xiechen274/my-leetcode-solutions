package hot100;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        // 如果树是空的，肯定是对称的
        if (root == null) {
            return true;
        }
        // 从根节点的左右子树开始检查
        return checkMirror(root.left, root.right);
    }
    private boolean checkMirror(TreeNode left, TreeNode right){
        //处理两个都为null
        if(left == null && right == null){
            return true;
        }
        //左右有一个为null代表不对称
        if(left == null || right == null){
            return false;
        }
        //都有值且值相等
        if(left.val == right.val){
            return checkMirror(left.left,right.right) && checkMirror(left.right,right.left);
        }else{
            return false;
        }
    }
}
