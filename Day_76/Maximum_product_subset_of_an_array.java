/*
Given an array A[]. The task is to find the maximum product possible with the subset of elements present in the array. The maximum product can be a single element also.
Since the product can be large, return it modulo (109 + 7).

Example 1:

Input:
A[] = {-1, -1, -2, 4, 3}
Output: 24
Explanation: Maximum product will be ( -2 * -1 * 4 * 3 ) = 24

Example 2:

Input:
A[] = {-1, 0}
Output: 0
*/

class Solution {
    public static int findMaxProduct(int n, int[] arr) {
         int mod=1000000007;
          if(n==1) return arr[0];
          long max = 1;
          int max_negative = Integer.MIN_VALUE;
          int count_neg = 0;
          int count_zero = 0;
          for(int i = 0;i<n;i++){
              if(arr[i]==0){
                  count_zero++;
                  continue;
              }
              else if(arr[i]<0){
                  max_negative = Math.max(max_negative,arr[i]);
                  count_neg++;
              }
              max =(max*arr[i])%mod;
          }
          if(count_zero==n) return 0;
          if(count_neg==1 && count_zero+count_neg==n) return 0;
          if(count_neg%2==1) max = max/max_negative;
          return (int)max;
    }
}