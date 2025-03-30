package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edward
 * @description
 * @date 2025/3/29
 */

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if (root == null) return retlist; // 返回空列表，而不是 null

        // 递归遍历左子树
        retlist.addAll(inorderTraversal(root.left));
        // 添加当前节点
        retlist.add(root.val);
        // 递归遍历右子树
        retlist.addAll(inorderTraversal(root.right));

        return retlist;
    }
}
