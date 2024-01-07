/*

You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]


*/

class Solution{
    //Function to count subarrays with sum equal to 0.
   public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i =0 ; i < n ; i++){
            sum = sum + arr[i];
            if(!map.keySet().contains(sum)){
                map.put(sum,1);
            }
            else{
                map.put(sum,map.get(sum)+1);
            }
        }
        long ans = 0;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(entry.getKey() == 0){
                ans = ans + ( ((val)*(val+1)) / 2 );
            }
            else{
                ans = ans + ( ((val-1)*(val)) / 2 );
            }
        }
        return ans;

    }
}