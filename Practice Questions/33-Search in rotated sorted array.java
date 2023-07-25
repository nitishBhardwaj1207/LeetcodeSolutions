class Solution {
    public int search(int[] nums, int target) {

        int indxofminele=findindexof_minele(nums,target);
        int left=binarysearch(nums,target,0,indxofminele-1);
        int right=binarysearch(nums,target,indxofminele,nums.length-1);
        return left==-1?right:left;

    }
    public int binarysearch(int []nums,int t,int s,int e)
    {
        while(s<=e)
        {
            int m=s+(e-s)/2;;
            if(nums[m]==t)
            {
                return m;
            }
            else if(nums[m]<t)
            {
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
        return -1;
    }
    public int findindexof_minele(int[] nums,int t)
    {
        int s=0;
        int e=nums.length-1;
        int n=nums.length;
        int ans=0;
       
        while(s<=e)
        {
            int m=s+(e-s)/2;
            int next=(m+1)%n;
            int prev=(m-1+n)%n;

            if((nums[m]<=nums[prev])&&(nums[m]<=nums[next]))
            {
                ans=m;
                return ans;
            }
            else if(nums[0]<=nums[m])
            {
                s=m+1;
            }
            else if(nums[m]<=nums[e])
            {
                e=m-1;
            }
        }
        return ans;
    }
}
