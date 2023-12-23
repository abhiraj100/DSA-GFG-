/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
 */

 class Solution
 {
     public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
     {
         ArrayList<Integer> list = new ArrayList<>();
         for(int i=0; i<K; i++){
             for(int j = 0;j<K; j++){
                 list.add(arr[i][j]);
             }
         }
         Collections.sort(list);
         return list;
         
     }
 }
 