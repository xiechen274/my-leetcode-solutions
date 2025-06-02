package hot100.tree;

import hot100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xlj
 * @date 2025-05-19
 * @description 二叉树转换为链表
 */

public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return; // 空树直接返回
        }
        flattenHelper(root); // 递归展开
    }

    private TreeNode flattenHelper(TreeNode root) {
        //基本情况
        if(root == null){
            return null;
        }

        TreeNode leftNode = flattenHelper(root.left);//展开左子树
        TreeNode rightNode = flattenHelper(root.right);//展开右子树

        //如果左子树有值就展开，没有的话就不需要处理了
        if(leftNode != null){
            leftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightNode != null ? rightNode : (leftNode != null ? leftNode : root);


    }
}
