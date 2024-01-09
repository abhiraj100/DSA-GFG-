/*
Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is [6, -3, -10] which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is [2, 3, 4, 5] which gives product as 120.
*/

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        
        long maxProductLeft = Integer.MIN_VALUE;
        long maxProductRight = Integer.MIN_VALUE;
        long curProductLeft = 1;
        long curProductRight = 1;
        
        
        for(int i = 0, j = n-1 ; i < n; i++,j--){
            curProductLeft *= arr[i];
            curProductRight *= arr[j];
            
            maxProductLeft = Math.max(curProductLeft, maxProductLeft);
            maxProductRight = Math.max(curProductRight, maxProductRight);
            
            if(curProductLeft == 0) curProductLeft = 1;
            if(curProductRight == 0) curProductRight = 1;
        }
        
        return Math.max(maxProductLeft, maxProductRight);
    }
}