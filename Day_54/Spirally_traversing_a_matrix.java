/*
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
*/



class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
     static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
         ArrayList<Integer> ans=new ArrayList<>();
         int sr=0,lr=r-1,sc=0,lc=c-1,t=r*c,count=0;
         
         while(count<t){
           
             
             for(int i=sc;i<=lc&&count<t;i++){
                 ans.add(matrix[sr][i]);
                 count++;
             }
             sr++;
             
             for(int i=sr;i<=lr&&count<t;i++){
                 ans.add(matrix[i][lc]);
                 count++;
             }
             lc--;
             
             for(int i=lc;i>=sc&&count<t;i--){
                 ans.add(matrix[lr][i]);
                 count++;
             }
             lr--;
             
             for(int i=lr;i>=sr&&count<t;i--){
                 ans.add(matrix[i][sc]);
                 count++;
             }
             sc++;
         }
         return ans;
    }
}
