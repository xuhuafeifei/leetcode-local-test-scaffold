package com.leetcode.convert;

import com.leetcode.CommonObject.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * ClassName: ConvertToInt
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:24
 */
public class ConvertToTreeNode extends ConvertFunc {

    @Override
    protected Class initType() {
        return TreeNode.class;
    }

    @Override
    public Object invoke(String arg) {
        String[] nums = super.getArrayFromString(arg);
        if (nums.length == 0) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode head = getTreeNode(nums[0]);
        deque.addLast(head);
        int idx = 1;
        while (deque.size() != 0) {
            int n = deque.size();
            for (int i = 0; i < n; ++i) {
                TreeNode node = deque.pollFirst();
                if (idx < nums.length) node.left = getTreeNode(nums[idx++]);
                if (idx < nums.length) node.right = getTreeNode(nums[idx++]);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
        }

        return head;
    }

    private TreeNode getTreeNode(String num) {
        if (Objects.equals(num, "null")) return null;
        return new TreeNode(Integer.parseInt(num));
    }

}
