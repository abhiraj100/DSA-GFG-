/*
You live in Geek land. Geek land can be seen as a grid of shape N x M.There are K enemy at K positions. Each enemy blocks the row and column to which it belongs. You have to find the largest continuous area that is not blocked.No two enemies share the same row or the same column.

Example 1:

Input:
N = 2
M = 2
K = 1
enemy[]={{2,2}}
Output:
1
Explanation:
Since only (1,1) cell is free from the enemy hence answer is 1.
 

Example 2:

Input:
N = 3
M = 3
K = 1
enemy[]={{3,3}}
Output:
4
Explanation:
The cells (1,1),(1,2) ,(2,1) and (2,2) are free hence answer =4.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function largestArea() which takes the size of geek land n,m and a 2-D matrix enemy of size k denoting the coordinates of the enemy's and need to return the largest area that is free.

Expected Time Complexity: O(KlogK)
Expected Auxiliary Space: O(K)
*/

class Solution {
    public static int largestArea(int n,int m,int k,int[][] enemy) {
        int[] rows = new int[n+1];
        int[] cols = new int[m+1];
        for(int i=0; i<k; ++i){
            
            rows[enemy[i][0]] = 1;
            cols[enemy[i][1]] = 1;
            
        }
        int prev = 0;
        int maxRowGap = 0;
        for(int i=1; i<n+1; ++i){
            if(rows[i] == 1){
                int gap = i-prev-1;
                maxRowGap = Math.max(maxRowGap,gap);
                prev = i;
            }
        }
        // last row
        maxRowGap = Math.max(maxRowGap,n+1-prev-1);
        prev = 0;
        int maxColGap = 0;
        for(int j=1; j<m+1; ++j){
            if(cols[j] == 1){
                int gap = j-prev-1;
                maxColGap = Math.max(maxColGap,gap);
                prev = j;
            }
        }
        // last col
        maxColGap = Math.max(maxColGap,m+1-prev-1);
        return maxRowGap*maxColGap;
    }
}
