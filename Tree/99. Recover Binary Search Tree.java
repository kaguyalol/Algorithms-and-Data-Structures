/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * [Reference I](https://www.youtube.com/watch?v=wGXB9OWhPTg)
     * [Reference II](https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer)
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1). Morris traversal
     */
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode first = null, second = null, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                //System.out.println(cur.val);
                if (pre != null && pre.val > cur.val) {
                    if (second == null)
                        second = pre;
                    first = cur;
                }  
                pre = cur;
                cur = cur.right;
                
            } else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur; // rightmost, will come back to root
                    cur = cur.left;
                } else {
                    temp.right = null;
                    //System.out.println(cur.val);
                    if (pre != null && pre.val > cur.val) {
                        if (second == null)
                            second = pre;
                        first = cur;
                    } 
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        if (first != null && second != null) {
            int v = first.val;
            first.val = second.val;
            second.val = v;
        }
    }
}