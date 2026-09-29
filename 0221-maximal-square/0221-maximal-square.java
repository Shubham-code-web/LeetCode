class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSideLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(
                        Math.min(dp[i][j + 1], dp[i + 1][j]),  
                        dp[i][j]                                 
                    ) + 1;
                    maxSideLength = Math.max(maxSideLength, dp[i + 1][j + 1]);
                }
            }
        }
      
        return maxSideLength * maxSideLength;
    }
}
