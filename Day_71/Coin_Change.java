/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

Example 1:

Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
*/

class Solution {
   public long count(int coins[], int N, int sum) {
     
        long[][]dp = new long[N+1][sum+1];   
        for(int i = 0 ; i <=N ; i++)
            dp[i][0] = 1l;
        
        for(int i = 1; i<=N ; i++)
            for(int j = 0; j<=sum; j++){
                if(coins[i-1] <=j)
                    dp[i][j] =  dp[i][j-coins[i-1]]+ dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        
        return dp[N][sum];
    }
}