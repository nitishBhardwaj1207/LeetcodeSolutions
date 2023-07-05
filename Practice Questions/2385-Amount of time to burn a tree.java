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
    TreeNode startnode;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode>mp=new HashMap<>();
        findparent(root,start,mp);
        Queue<TreeNode> q=new ArrayDeque<>();
        HashSet<TreeNode> vis=new HashSet<>();
        q.add(startnode);
        int min=0;
       
        while(q.size()>0)
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.remove();
                vis.add(curr);
                if(curr.left!=null&& !vis.contains(curr.left))
                {
                    q.add(curr.left);
                }
                 if(curr.right!=null&& !vis.contains(curr.right))
                {
                    q.add(curr.right);
                }
                if(mp.containsKey(curr) &&!vis.contains(mp.get(curr)))
                {
                    q.add(mp.get(curr));
                }
            }
            min++;

        }
        return min-1;
    }
    public void findparent(TreeNode root,int s,HashMap<TreeNode,TreeNode>mp)
    {
        if(root==null)
            return ;
        if(root.val==s)
        {
            startnode=root;
            return;
        }
        if(root.left!=null)
        {
            mp.put(root.left,root);
        }
         if(root.right!=null)
        {
            mp.put(root.right,root);
        }
        findparent(root.left,s,mp);
         findparent(root.right,s,mp);
    }
}
