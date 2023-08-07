class Solution {
    public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>>res=new ArrayList<>();
       boolean []freq=new boolean[nums.length];
        helper(nums,new ArrayList<>() ,res,freq);
        return res;

        }

         public void helper(int[]nums,List<Integer>l, List<List<Integer>>res,boolean[]freq)
         {
             if(l.size()==nums.length)
             {
                 res.add(new ArrayList<>(l));
             }

            for(int i=0;i<nums.length;i++)
            {
                if(freq[i]==true)continue;
                freq[i]=true;
                l.add(nums[i]);
                helper(nums,l,res,freq);
                l.remove(l.size()-1);
                freq[i]=false;
            }
          
         }
        
    }
