class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
class Solution {
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
