/*
Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.

Example 1:

Input : 
n = 4, k = 10
a[] = {1, 2, 3, 4}
Output : 
7
Explanation:
The contiguous subarrays are {1}, {2}, {3}, {4} 
{1, 2}, {1, 2, 3} and {2, 3}, in all these subarrays
product of elements is less than 10, count of
such subarray is 7.
{2,3,4} will not be a valid subarray, because 
2*3*4=24 which is greater than 10.
Example 2:

Input:
n = 7 , k = 100
a[] = {1, 9, 2, 8, 6, 4, 3}
Output:
16
*/

class Solution {
    
 public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        long ans = 0, product = 1;
        int i = 0, j = 0;
        while(j < n) {
            // calc
            product *= a[j];
            if(product < k){
                ans += j-i+1;
                j++;
            }
            else{
                while(i<=j && product>=k){
                    product /= a[i];
                    i++;
                }
                if(i<=j && k != 0) {
                    ans += j-i+1;
                }
                j++;
                
            }
        }
        
        return ans;
        
    }
}