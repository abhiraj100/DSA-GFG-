/*
Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
Starting from any column in row 0 return the largest sum of any of the paths up to row N-1.

NOTE: We can start from any column in zeroth row and can end at any column in (N-1)th row.

Example 1:

Input: N = 2
Matrix = {{348, 391},
          {618, 193}}
Output: 1009
Explaination: The best path is 391 -> 618. 
It gives the sum = 1009.

Example 2:

Input: N = 2
Matrix = {{2, 2},
          {2, 2}}
Output: 4
Explaination: No matter which path is 
chosen, the output is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maximumPath() which takes the size N and the Matrix as input parameters and returns the highest maximum path sum.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1 ≤ N ≤ 500
1 ≤ Matrix[i][j] ≤ 1000
*/

class Solution{
    static int maxSum(int row, int col , int Matrix[][] , int dp[][]){
        
        int n = Matrix.length;
        
        if(col < 0 || col >= n) return (int)(-1e9 + 7);
        
        if(row == 0) return Matrix[0][col];
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int up = Matrix[row][col] + maxSum(row-1 , col , Matrix , dp);
        int left = Matrix[row][col] + maxSum(row-1 , col-1 , Matrix , dp);
        int right = Matrix[row][col] + maxSum(row-1 , col+1 , Matrix , dp);
        
        return dp[row][col] = Math.max(up , Math.max(left , right));
    }
    static int maximumPath(int N, int Matrix[][])
    {
        int dp[][] = new int[N][N];
        
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        
        int max = 0;
        for(int i = 0 ; i<N ; i++){
            int sum = maxSum(N-1, i , Matrix , dp);
            max = Math.max(sum , max);
        }
        return max;
    }
}