/*
 * Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explanation:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.
 */

 class ArraySwap{
    
    public int minSwaps(int nums[]){ 
        int n=nums.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=nums[i];
        }
    
      Arrays.sort(temp);
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<n;i++){
          map.put(nums[i],i);
      }
      int swap=0;
      for(int i=0;i<n;i++){
          if(temp[i]!=nums[i]){
              swap++;
            int idx=  map.get(temp[i]);
            int data=nums[i];
            nums[i]=temp[i];
            nums[idx]=data;
            map.put(data,idx);
          }
      }
      return swap;
    }
}