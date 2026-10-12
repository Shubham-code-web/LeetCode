class Solution {
    private int[][] image;         
    private int originalColor;       
    private int newColor;            
    private final int[] directions = {-1, 0, 1, 0, -1};
  
 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        originalColor = image[sr][sc];
      
        // If original color equals new color, no change needed
        if (originalColor == color) {
            return image;
        }
      
        // Initialize instance variables
        this.image = image;
        this.newColor = color;
      
        // Start DFS from the starting position
        dfs(sr, sc);
      
        return image;
    }
  
    private void dfs(int row, int col) {
        // Fill current cell with new color
        image[row][col] = newColor;
      
        // Explore all 4 adjacent directions
        for (int k = 0; k < 4; k++) {
            // Calculate next cell coordinates
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
          
            // Check if next cell is valid and has the original color
            if (nextRow >= 0 && nextRow < image.length && 
                nextCol >= 0 && nextCol < image[0].length && 
                image[nextRow][nextCol] == originalColor) {
                // Recursively fill the adjacent cell
                dfs(nextRow, nextCol);
            }
        }
    }
}
