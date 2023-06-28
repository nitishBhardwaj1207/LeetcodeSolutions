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
     int sum=0;
    List<String> l=new ArrayList<>();
    public int sumNumbers(TreeNode root) {

        if(root==null)
           return 0;
        helper(root,"");
        for(int i=0;i<l.size();i++)
        {
            String val=l.get(i);
             int vals=Integer.parseInt(val,10);
             sum+=vals;
        }
        return sum;
    }
    public void helper(TreeNode root,String p)
    {
        if(root==null)
        {
            return;
        }
       if(root.left==null&&root.right==null)
       {
          
           l.add(p+root.val+"");
           return ;
       }
       p+=root.val+"";
        helper(root.left,p);
        helper(root.right,p);
    }
}
