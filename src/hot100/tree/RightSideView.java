package hot100.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hot100.TreeNode;


/**
 * @author xlj
 * @date 2025-05-18
 * @description 二叉树的右视图
 */

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //先将头部放入
        queue.offer(root);
        while(!queue.isEmpty()){
            //边循环边记录最后一个节点
            int size = queue.size();
            int lastNode = 0; //用于维护最后一个节点
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                lastNode = poll.val;
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            ret.add(lastNode);

        }

        return ret;


    }


}
