class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       List<Integer> l=new ArrayList<>();
     
        HashMap<Integer,Integer>m1=new HashMap<>();
      
        for(int i=0;i<nums1.length;i++)
        {
            if(m1.containsKey(nums1[i]))
            {
                m1.put(nums1[i],m1.get(nums1[i]+1));
            }
            else{
                m1.put(nums1[i],1);
            }
        }
      for(int i=0;i<nums2.length;i++)
      {
          int j=nums2[i];
          if(m1.containsKey(j))
          {
              l.add(j);
              m1.remove(j);
          }
      }
        int[]arr=new int[l.size()];
      for(int i=0;i<l.size();i++)
      {
          arr[i]=l.get(i);
      }
      
      return arr;

    }
}
