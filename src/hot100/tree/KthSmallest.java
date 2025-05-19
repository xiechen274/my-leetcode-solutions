package hot100.tree;

import hot100.TreeNode;

/**
 * @author xlj
 * @date 2025-05-18
 * @description 二叉搜索树中第K小的元素
 */

public class KthSmallest {

    private int count;
    private int ret;

    public int kthSmallest(TreeNode root, int k) {
        //初始化变量
        count = 0;
        ret = 0;

        inOrder(root,k);
        return ret;
    }

    public void inOrder(TreeNode root, int k){
        //中序遍历
        if(root == null){
            return;
        }
        inOrder(root.left,k);
        count++;
        if(k == count){
            ret = root.val;
        }
        inOrder(root.right,k);
    }
}
