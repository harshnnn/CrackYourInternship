class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

      PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] arg0, int[] arg1) {
               return (arg1[1]-arg1[0])==(arg0[1]-arg0[0])?arg0[0]-arg1[0]:(arg1[1]-arg1[0])-(arg0[1]-arg0[0]);
            }
            
        });

        pq.add(new int[]{points[0][0], points[0][1]});

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < points.length; i++) {

            while(!pq.isEmpty() && points[i][0] - pq.peek()[0] > k ) {
                pq.poll();
            }

            
            if ( !pq.isEmpty() ) {
                max = Math.max(max, points[i][0] - pq.peek()[0] + pq.peek()[1] + points[i][1]);
            }
            
            pq.add(new int[]{points[i][0], points[i][1]});

            
        }
        

        return max;
    }
}