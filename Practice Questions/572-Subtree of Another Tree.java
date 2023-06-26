//difficulty-easy
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null)
           return true;
        if(root!=null&&subRoot==null)
            return true;
        if(root==null&&subRoot!=null)
            return false;
        boolean ans=identical(root,subRoot);
        if(ans)
            return true;
        return  isSubtree(root.left,  subRoot) ||  isSubtree(root.right,  subRoot) ;
           
        
    }
    public boolean identical(TreeNode root1,TreeNode  root2)
    {
        if(root1==null&&root2==null)
             return true;
        if(root1!=null&&root2==null)
           return false;
         if(root1==null&&root2!=null)
           return false;
         if(root1.val!=root2.val)
             return false;
        boolean l= identical(root1.left,root2.left);
         boolean r= identical(root1.right,root2.right);
         return l&&r;
    }
}
