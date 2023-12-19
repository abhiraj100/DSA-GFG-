/*
Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task is to find the column with maximum number of 0s. If more than one column exists, print the one which comes first. If the maximum number of 0s is 0 then return -1.

Example:

Input:
N = 3
M[][] = {{0, 0, 0},
          {1, 0, 1},
          {0, 1, 1}}
Output:
0
*/

class Matrix
{
   int columnWithMaxZeros (int arr[][] , int N)
   {
       int maxZero = 0;
       int answer = -1;
       for (int i=0; i<N; i++) {
           int currZero = 0;
           for (int j=0; j<N; j++){
               if (arr[j][i]==0){
                   currZero++;
               }
           }
           if (currZero > maxZero) {
               answer = i;
           }
           maxZero = Math.max(currZero, maxZero);
       }
       return answer;
   }
}
