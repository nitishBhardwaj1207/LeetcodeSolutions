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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        int lev=0;
        int h=height(root);
        q.add(root);
        while(q.size()>0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.remove();
                if(lev==h)
                {
                    return n.val;
                }
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }

            }
            lev++;
        }

        return -1;
    }
    public int height(TreeNode root)
    {
        if(root==null)
            return -1;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
}
