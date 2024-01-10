/*
Given an array arr containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
Output: 
4
Explanation:
The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
Example 2:

Input:
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output: 
5
Explanation:
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
*/

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        //contain reminder and it's position 
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        map.put(0,-1);
        int sum = 0;
        int reminderSum=0;
        for(int i=0;i<n;i++){
            sum += a[i];
            reminderSum = sum%k;
            if(reminderSum<0){
                reminderSum += k;
            }
            if(!map.containsKey(reminderSum)){
                map.put(reminderSum,i);
            }else{
                maxLength = Math.max(maxLength,i-map.get(reminderSum));
            }
        }
        
        return (maxLength==Integer.MIN_VALUE)?0:maxLength;
    }
}