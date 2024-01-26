/*
You are given an array Arr of size N. You have to find the K-th largest sum of contiguous subarray within the array elements. In other words, over all subarrays, find the subarray with k-th largest sum and return its sum of elements.

 

Example 1:

Input:
N = 3
K = 2
Arr = {3,2,1}
Output:
5
Explanation:
The different subarray sums we can get from the array
are = {6,5,3,2,1}. Where 5 is the 2nd largest.
 

Example 2:

Input:
N = 4
K = 3
Arr = {2,6,4,1}
Output:
11
Explanation:
The different subarray sums we can get from the array
are = {13,12,11,10,8,6,5,4,2,1}. Where 11 is the 3rd largest.
*/

class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
    PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            int sum=Arr[i];
            q.add(sum);
            for(int j=i+1;j<N;j++){
                sum+=Arr[j];
                q.add(sum);
                
            }
        }
        for(int i=0;i<K-1;i++){
            q.poll();
        }
        return q.peek();
    }
}