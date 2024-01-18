/*
Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.

Example 1:

Input : 
arr[ ] = {2, 1, 5, 6, 3} 
K = 3
Output : 
1
Explanation:
To bring elements 2, 1, 3 together,
swap index 2 with 4 (0-based indexing),
i.e. element arr[2] = 5 with arr[4] = 3
such that final array will be- 
arr[] = {2, 1, 3, 6, 5}

Example 2:

Input : 
arr[ ] = {2, 7, 9, 5, 8, 7, 4} 
K = 6 
Output :  
2 
Explanation: 
To bring elements 2, 5, 4 together, 
swap index 0 with 2 (0-based indexing)
and index 4 with 6 (0-based indexing)
such that final array will be- 
arr[] = {9, 7, 2, 5, 4, 7, 8}
*/

class Complete{
    public static int minSwap (int arr[], int n, int k) {
        int f=0,nf=0;
        for(int a:arr) if(a<=k) f++;
        
        
        for(int i=0;i<f;i++){
            if(arr[i]>k) nf++;
            
        }
        
        int l=0,r=f-1,res=Integer.MAX_VALUE;
        
        
        while(r<n){
            
            res=Math.min(res,nf);
            r++;
            if(r<n && arr[r]>k) nf++;
            if(l<n && arr[l]>k) nf--;
            l++;
        }
        return res;
    }
    
}