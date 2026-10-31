class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        while(!q.isEmpty()){
            int polled[]=q.poll();
            time=polled[2];
            int x[]=new int[]{-1,+1,0,0};
            int y[]=new int[]{0,0,-1,+1};
            for(int i=0;i<4;i++){
                int xpoint=polled[0]+x[i];
                int ypoint=polled[1]+y[i];
                if(xpoint>=0 && xpoint<n && ypoint>=0 && ypoint<m){
                    if(grid[xpoint][ypoint]==1){
                        grid[xpoint][ypoint]=2;
                        fresh--;
                        q.add(new int[]{xpoint,ypoint,time+1});
                    }
                }
            }
        }
        if(fresh==0) return time;
        return -1;
    }
}