/*
Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Note :-  l and r denotes the starting and ending index of the array.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
L=0 R=5

Output : 7
*/


class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        Arrays.sort(arr);
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(mid==k-1)
                return arr[mid];
            else if(mid<k-1)
                l=mid+1;
            else
                r=mid-1;
        }
        return arr[l];
    } 
}