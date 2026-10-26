class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
      int n=grid.length;
      if(grid[0][0]==1 || grid[n-1][n-1]==1){
        return -1;
      } 
      Queue<int[]> q=new LinkedList<>();
      q.offer(new int[]{0,0,1});
      grid[0][0]=1;
      int[] dr={-1,-1,-1,0,0,1,1,1};
      int[] dc={-1,0,1,-1,1,-1,0,1};
      while(!q.isEmpty()){
        int[] curr=q.poll();
        int r=curr[0];
        int c=curr[1];
        int dist=curr[2];
        if(r==n-1 && c==n-1){
            return dist;
        }
        for(int i=0;i<8;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc]==0){
                grid[nr][nc]=1;
                q.offer(new int[]{nr,nc,dist+1});
            }
        }
      }
      return -1;
        
    }
}