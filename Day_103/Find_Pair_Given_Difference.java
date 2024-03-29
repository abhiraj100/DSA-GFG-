/*
Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.

Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.
Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
Your Task:
You need not take input or print anything. Your task is to complete the function findPair() which takes array arr, size of the array L and N as input parameters and returns True if required pair exists, else return False.

Expected Time Complexity: O(L* Log(L)).
Expected Auxiliary Space: O(1).

Constraints:
1<=L<=104 
1<=Arr[i]<=105 

0<=N<=105
*/

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        
       HashMap<Integer,Integer> hm = new HashMap<>();
       
       for(int i=0;i<arr.length;i++){
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
       }
       if(n==0){
            for(int i=0;i<arr.length;i++){
                if(hm.get(arr[i])>=2){
                    return true;
                }
            }
       }
        else{
       for(int i=0;i<arr.length;i++){
           //hm.put(arr[i],hm.get(arr[i]-1));
           int com = n + arr[i];
           if(hm.containsKey(com)  ){
               return true;
           }
       }
      }
       
        return false;
    }
}