/*
Given a boolean 2D array of n x m dimensions, consisting of only 1's and 0's, where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).
*/

class Solution {
   int rowWithMax1s(int arr[][], int n, int m) {
        
        int maxOnes = -1;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1)
                    cnt++;
            }
            if(cnt > maxOnes && cnt != 0) {
                idx = i;
                maxOnes = cnt;
            }
        }
        return idx; 
    }
}