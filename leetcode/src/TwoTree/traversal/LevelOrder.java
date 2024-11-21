package TwoTree.traversal;

import common.domain.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历
 *
 * @author wangyc
 * @date 2022/10/16
 */
public class LevelOrder {

    // 使用迭代方式遍历
    public static List<List<Integer>> forEach(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.poll();
                levelList.add(treeNode.getVal());
                if (treeNode.getLeft() != null) {
                    list.add(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    list.add(treeNode.getRight());
                }
            }
            res.add(levelList);
        }
        return res;
    }

    //全局变量
    static List<List<Integer>> res = new ArrayList<>();
    // 方法二、使用前序遍历
    public static List<List<Integer>> headForEach(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> curTreeNodes = new ArrayList<>();
        curTreeNodes.add(root);
        curForEach(curTreeNodes);
        return res;
    }

    // 递归处理二叉树每一层的数据
    public static void curForEach(List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> curList = new ArrayList<>();
        List<TreeNode> nextTreeNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            curList.add(node.getVal());
            if (node.getLeft() != null) {
                nextTreeNodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nextTreeNodes.add(node.getRight());
            }
        }
        res.add(curList);
        curForEach(nextTreeNodes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode twoL = new TreeNode(2);
        TreeNode twoR = new TreeNode(3);
        TreeNode threeL = new TreeNode(4);
        TreeNode threeR = new TreeNode(5);
        TreeNode fourL = new TreeNode(6);
        TreeNode fourR = new TreeNode(7);
        root.setLeft(twoL); root.setRight(twoR);
        twoL.setLeft(threeL); twoR.setRight(threeR);
        threeL.setLeft(fourL); threeR.setRight(fourR);

        System.out.println(forEach(root));
        System.out.println(headForEach(root));
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>();

    }

}
