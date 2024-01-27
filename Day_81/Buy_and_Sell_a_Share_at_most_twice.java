/*
In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, the second transaction can only start after the first one is complete (Buy->sell->Buy->sell). The stock prices throughout the day are represented in the form of an array of prices. 

Given an array price of size N, find out the maximum profit that a share trader could have made.

Example 1:

Input:
6
10 22 5 75 65 80
Output:
87
Explanation:
Trader earns 87 as sum of 12, 75 Buy at 10, sell at 22, Buy at 5 and sell at 80.
Example 2:

Input:
7
2 30 15 10 8 25 80
Output:
100
Explanation:
Trader earns 100 as sum of 28 and 72 Buy at price 2, sell at 30, Buy at 8 and sell at 80,
*/

class Solution {
    public static int maxProfit(int n, int[] arr) {
        // code here
        int dp[][][] = new int[n+1][2][3];
        for(int i = 0; i <= n - 1; i++){
            for(int buy = 0; buy <= 1; buy++){
                dp[i][buy][0] = 0;
            }
        }
        for(int buy = 0; buy <= 1; buy++){
            for(int tran = 0; tran <= 2; tran++){
                dp[n][buy][tran] = 0;
            }
        }
        
        for(int i = n - 1; i >= 0;i--){
            for(int buy = 0; buy <= 1; buy++){
                for(int tran = 1; tran <= 2; tran++){
                     int profit = 0;
                     if(buy == 1){
                       profit =  Math.max(-arr[i] + dp[i+1][0][tran],0 + dp[i+1][1][tran]);
                     }else{
                       profit =  Math.max(arr[i] + dp[i+1][1][tran-1],0 + dp[i+1][0][tran]); 
                     }
                     dp[i][buy][tran] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
}