/*
Given an array arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the minimum sum and return its sum.

Example 1:

Input: 
arr[] = {3,-4, 2,-3,-1, 7,-5}
Output: -6
Explanation: sub-array which has smallest 
sum among all the sub-array is {-4,2,-3,-1} = -6
Example 2:

Input:
arr[] = {2, 6, 8, 1, 4}
Output: 1
Explanation: sub-array which has smallest
sum among all the sub-array is {1} = 1
*/

class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        int min = Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<size;i++){
            sum += a[i];
            if(sum>a[i]){
                sum = a[i];
            }
           min = Math.min(sum,min);
        }
        return min;
    }
}