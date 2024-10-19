package com.leetcode.CommonObject;

public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode() {}
   public TreeNode(int val) { this.val = val; }
   public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
   }
   public void print() {
        dfs(this);
   }

   private void dfs(TreeNode node) {
       if (node == null) return;
       System.out.println(node.val);
       dfs(node.left);
       dfs(node.right);
   }
}
