/*
Given a N x M grid. Find All possible paths from top left to bottom right.From each cell you can either move only to right or down.

Example 1:

Input: 1 2 3
       4 5 6
Output: 1 4 5 6
        1 2 5 6 
        1 2 3 6
Explanation: We can see that there are 3 
paths from the cell (0,0) to (1,2).
Example 2:

Input: 1 2
       3 4
Output: 1 2 4
        1 3 4
Your Task:
You don't need to read input or print anything. Your task is to complete the function findAllPossiblePaths() which takes two integers n,m and grid[][]  as input parameters and returns all possible paths from the top left cell to bottom right cell in a 2d array.

Expected Time Complexity: O(2^N*M)
Expected Auxiliary Space: O(N)


Constraints:
1 <= n,m <= 10 
1 <= grid[i][j] <= n*m
n * m < 20
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        findPath(n,m,0,0,grid,res,new ArrayList<>());
        return res;
    }
    public static void findPath(int n,int m,int i,int j, int[][] grid,ArrayList<ArrayList<Integer>>res,ArrayList<Integer>temp){
       
        if(i+1<n){
            temp.add(grid[i][j]);
            findPath(n,m,i+1,j,grid,res,temp);
            temp.remove(temp.size()-1);
        }
        if(j+1<m){
            temp.add(grid[i][j]);
            findPath(n,m,i,j+1,grid,res,temp);
            temp.remove(temp.size()-1);
        }
        if(i==n-1 && j==m-1){
            temp.add(grid[i][j]);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
    }
}