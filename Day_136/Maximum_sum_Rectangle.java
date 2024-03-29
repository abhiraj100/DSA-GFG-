/*
Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29
Explanation:
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.
Thumbnail
Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the 
optimal choice.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum submatrix.


Expected Time Complexity:O(R*R*C)
Expected Auxillary Space:O(R*C)
 

Constraints:
1<=R,C<=500
-1000<=M[i][j]<=1000
*/

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int dp[][] = new int[R][C];
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(i==0)
                dp[i][j] = M[i][j];
                else {
                    dp[i][j] = M[i][j] + dp[i-1][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int k=0;k<R;k++) {
            for(int i=k;i<R;i++) {
                int sum = 0;
                for(int j=C-1;j>=0;j--) {
                    int curSum = dp[i][j];
                    if(k>0)
                    curSum -= dp[k-1][j];
                    sum += curSum;
                    if(sum<curSum)
                    sum = curSum;
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }
};
