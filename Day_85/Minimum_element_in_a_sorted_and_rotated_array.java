/*
A sorted(in ascending order) array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Example 1

Input:
N = 5
arr[] = {4 ,5 ,1 ,2 ,3}
Output: 1
Explanation: 1 is the minimum element in the array.
Example 2

Input:
N = 7
arr[] = {10, 20, 30, 40, 50, 5, 7}
Output: 5
Explanation: Here 5 is the minimum element.
*/

class Solution
{
    int findMin(int arr[], int n)
    {
            int left=0;
            int right=n-1;
            
            while(left<=right){
                int mid=left+right>>1;
                int next=(mid+1)%n;
                int prev=(mid+n-1)%n;
                
                if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                    return arr[mid];
                }else if(arr[mid]<arr[right]) {
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            return -1;
    }
}
