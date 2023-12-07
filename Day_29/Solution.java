class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
    { 
        // code here
        long product = 1;
        long arr[] = new long[n];
        int zeroCount = 0;
        int zeroIndex = -1;
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                zeroCount++;
                zeroIndex = i;
            }else{
                product *= nums[i];
            }
        }
        if(zeroCount > 1) return arr;
        
        if(zeroCount == 0){
            for(int i = 0; i<n; i++){
                arr[i] = product/nums[i];
            }
        }else{
            arr[zeroIndex] = product;
        }
        return arr;
    }
} 