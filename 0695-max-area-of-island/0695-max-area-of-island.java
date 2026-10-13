import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Step 1: Traverse every single cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                // Step 2: If we find land (1), start a BFS to calculate its area
                if (grid[r][c] == 1) {
                    int currentArea = 0;
                    
                    // Queue stores coordinates as a 1D array: [row, col]
                    Queue<int[]> queue = new LinkedList<>();
                    
                    // Add the starting land cell to the queue
                    queue.offer(new int[]{r, c});
                    // Immediately sink it to mark it as visited
                    grid[r][c] = 0; 
                    
                    // Step 3: Process the queue until it's empty
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int currRow = cell[0];
                        int currCol = cell[1];
                        
                        // We successfully pulled a land cell, increment area
                        currentArea++;
                        
                        // Define the 4 cardinal directions: Down, Up, Right, Left
                        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        
                        // Check all 4 neighboring directions
                        for (int[] dir : directions) {
                            int nextRow = currRow + dir[0];
                            int nextCol = currCol + dir[1];
                            
                            // Check boundary limits and ensure the neighbor is land (1)
                            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                                queue.offer(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = 0; // Sink immediately to avoid duplicate queues
                            }
                        }
                    }
                    
                    // Step 4: Record the largest island area found so far
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }
}
