class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
    List<List<Integer>>ans=new ArrayList<>();
      ans=sieve(n);
      return ans;
}
  public List<List<Integer>>sieve(int n)
  {
     List<List<Integer>>ans=new ArrayList<>();
    boolean [] isprime=new boolean[n+1];
    Arrays.fill(isprime,true);
    isprime[0]=false;
    isprime[1]=false;
    for(int i=2;i*i<=n;i++)
      {
        for(int j=2*i;j<=n;j=j+i)
          {
            isprime[j]=false;
          }
      }
    for(int i=2;i<=n/2;i++)
      {
        if(isprime[i] && isprime[n-i])
        {
          ans.add(Arrays.asList(i,n-i));
        }
      }
    return ans;
  }
}
