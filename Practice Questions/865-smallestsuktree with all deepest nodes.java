//difficulty-medium

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
 class NodeDep{
     TreeNode node;
     int dep;

     public NodeDep(  TreeNode node,int dep)
     {
         this.node=node;
         this.dep=dep;
     }
 }
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        NodeDep d=helper(root);
        return d.node;
    }

    public NodeDep helper(TreeNode root)
    {

        if(root==null)
        {
            NodeDep np=new NodeDep(null,0);
            return np;
        }

        NodeDep lp=helper(root.left);
        NodeDep rp=helper(root.right);
        if(lp.dep==rp.dep)
        {
            NodeDep np=new NodeDep(root,lp.dep+1);
            return np;
        }

        if(lp.dep>rp.dep)
        {
            NodeDep np=new NodeDep(lp.node,lp.dep+1);
            return np;

        }
        else{
             NodeDep np=new NodeDep(rp.node,rp.dep+1);
            return np;

        }
    }

   
}
