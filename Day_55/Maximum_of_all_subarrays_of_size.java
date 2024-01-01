/*
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6
*/



class Solution
{
    //Function to find maximum of each subarray of size k.
     static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int max= arr[0];
        for(int i=0;i<n-k+1;i++)
        {
            max=arr[i];
            for(int j = i+1;j<i+k;j++)
            max = max<arr[j]?arr[j]:max;
            list.add(max);
        }
        return list;
    }
}