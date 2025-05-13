package hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xlj
 * @date 2025-05-13
 * @description 层序遍历
 */

public class LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            while (l < r) { // 队列里还有东西
                int size = r - l;
                //创建list存放当前层数的节点
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        //初始化条件
        l = r = 0;
        queue[r++] = root;
        while(l < r){
            int size = r - l;//之后重复size遍
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode curNode = queue[l]; //临时存放
                list.add(queue[l++].val);

                if(curNode.left != null){
                    queue[r++] = curNode.left;
                }
                if (curNode.right != null) {
                    queue[r++] = curNode.right;
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        LevelOrder solution = new LevelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result0 = solution.levelOrder2(root);
        System.out.println("Test Case 1 (Empty Tree): " + result0); // 预期: []

        // 用例 1：空树
        TreeNode root1 = null;
        List<List<Integer>> result1 = solution.levelOrder(root1);
        System.out.println("Test Case 1 (Empty Tree): " + result1); // 预期: []

        // 用例 2：单节点
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println("Test Case 2 (Single Node): " + result2); // 预期: [[1]]

        // 用例 3：完整二叉树
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        List<List<Integer>> result3 = solution.levelOrder(root3);
        System.out.println("Test Case 3 (Complete Tree): " + result3); // 预期: [[3],[9,20],[15,7]]

        // 用例 4：偏斜树（左偏）
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        root4.left.left.left.left = new TreeNode(5);
        List<List<Integer>> result4 = solution.levelOrder(root4);
        System.out.println("Test Case 4 (Left Skewed): " + result4); // 预期: [[1],[2],[3],[4],[5]]

        // 用例 5：混合树
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.left = new TreeNode(3);
        List<List<Integer>> result5 = solution.levelOrder(root5);
        System.out.println("Test Case 5 (Mixed Tree): " + result5); // 预期: [[1],[2],[3]]
    }
}

