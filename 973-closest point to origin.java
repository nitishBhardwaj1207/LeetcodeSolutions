class Solution {
    static class points{
        int x;
        int y;

        public points(int x,int y)
        {
            this.x=x;
            this.y=y;

        }
    }
    static class pointsd implements Comparable<pointsd>{
        points p;
        int d;

        public pointsd(points x,int d)
        {
            this.p=x;
            this.d=d;
        }
        public int compareTo(pointsd o)
        {
            return o.d-this.d;
        }
    }

    public int[][] kClosest(int[][] point, int k) {

        PriorityQueue<pointsd> pq=new PriorityQueue<>();
        for(int i=0;i<point.length;i++)
        {
                int dist=point[i][0]*point[i][0]+point[i][1]*point[i][1];
                pointsd pd=new pointsd(new points(point[i][0],point[i][1]),dist);
                pq.add(pd);
                if(pq.size()>k)
                {
                    pq.remove();
                }
        }
        int[][]ans=new int[k][2];
        int idx=0;
        while(pq.size()>0)
        {
            pointsd pd=pq.remove();
             ans[idx++] = new int[] { pd.p.x, pd.p.y };
        }
        return ans;
    }
}
