/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500


*/

class Solution {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) {
            return 0;
        }

        q.add(new int[]{-1, -1});
        int count = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];

            // If reached the end of a level
            if (i == -1 && j == -1) {
                if (!q.isEmpty()) {
                    count++;
                    q.add(new int[]{-1, -1});
                }
            } else {
                // Process adjacent fresh oranges
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        freshOranges--;
                        if (freshOranges == 0) {
                            return count + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
