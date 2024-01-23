/*
Given a sorted array arr containing n elements with possibly some duplicate, the task is to find the first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.


Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  
2 5
Explanation: 
First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 
Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  
6 6
Explanation: 
First and last occurrence of 7 is at index 6.
*/

class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        
        int firstOccurence = binarysearchfirstoccr(arr , 0 , n-1, x);
        int lastOccurence = binarysearchlastoccur(arr, 0 , n-1,x);
        
        li.add(firstOccurence);
        li.add(lastOccurence);
        
        return li;
        
    }
    
    private int binarysearchfirstoccr(int[] arr,int low,int high,int x){
        
        int result = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                result = mid;
                high = mid -1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
    
    private int binarysearchlastoccur(int[] arr, int low, int high, int x){
        
        int result = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                result = mid ;
                low=mid+1;
            }else if(arr[mid]>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}