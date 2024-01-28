/*
Given an array arr[] of size N and an integer K. The task is to find the minimum number of elements that should be removed, such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered among the remaining elements. 

Note: Can you solve the probelm without using any extra space and O(N*log(N)) time complexity?

Example 1:

Input: N = 9, K = 4  
arr[] = {1,3,4,9,10,11,12,17,20}
Output: 5
Explanation: Remove 1, 3, 4 from beginning
and 17, 20 from the end.
Example 2:

Input: N = 5, K = 2 
arr[] = {1, 5, 6, 2, 8} 
Output: 3
Explanation: There are multiple ways to
remove elements in this case.
One among them is to remove 5, 6, 8.
The other is to remove 1, 2, 5
*/

class Solution {
    int removals(int[] arr, int n, int k) {
        if(n==1) return 0;
        int max=Integer.MIN_VALUE;
        
        Arrays.sort(arr);
        Queue<Integer> q=new LinkedList<>();
        q.add(arr[0]);
        for(int i=1;i<n;i++){
           
            while(!q.isEmpty()&&arr[i]-q.peek()>k){
                q.poll();
                
            }
            q.add(arr[i]);
        
            max=Math.max(max,q.size());
        }
       
       
        return n-max;
    }
}