/*
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 


Expected Time Complexity: O(R), where R is the maximum integer in the array.
Expected Auxiliary Space: O(N).
*/

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
static int findLongestConseqSubseq(int arr[], int N)
{
   // add your code here
     int fini =1;
     int count = 1;
     Arrays.sort(arr);
     for(int i=1;i<N;i++){
         if(arr[i]==arr[i-1]){
             continue ; 
         }
         if(arr[i]==arr[i-1]+1){
             count++;
             fini = Math.max(fini,count);
             
         }else if (arr[i]!=arr[i-1]+1){
             count =1;
         }
     }
     return fini ;
 
}
}