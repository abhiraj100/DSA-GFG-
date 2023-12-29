/*
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
*/


import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        long low = 0;
        long high = N-1;
        return inv(arr,low,high);
        
    }
    public static long inv(long arr[], long low, long high){
        long res = 0;
        if(high>low){
            long mid = (low+high)/2;
            res +=inv(arr, low, mid);
            res +=inv(arr,mid+1,high);
            res +=countMerge(arr,mid,low,high);
        }
        return res;
    }
    static long countMerge(long arr[], long mid, long low, long high){
        long n1 = mid - low + 1;
        long n2 = high - mid;
        long res = 0;
        long left[] = new long[(int)n1];
        long right[] = new long[(int)n2];
        for(int i=0;i<n1;i++){
            left[i] = arr[i+(int)low];
        }
        for(int j=0;j<n2;j++){
            right[j] = arr[(int)mid+1+j];
        }
        int i=0;
        int j=0;
        int k = (int)low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                res = res+(n1 - i);
                
            }
        }
         while(i<n1 ){
            
                arr[k++] = left[i++];
           
        }
        while(j<n2 ){
            
                arr[k++] = right[j++];
           
        }
        return res;
    }
}