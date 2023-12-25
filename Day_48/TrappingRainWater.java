/*
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
*/



class TrappingRainWater{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        
        //calculate leftmax array
        int leftmax []=new int [n];
        leftmax[0]=arr[0];
        for(int i=1;i<n;i++)
            leftmax[i]=Math.max(arr[i],leftmax[i-1]);
        
        //calculate rightmax array
        int rightmax []=new int[n];
        rightmax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            rightmax[i]=Math.max(arr[i], rightmax[i+1]);
                                                          
        long trappedWater=0;
        //trappedWater = waterLevel - height of bar
        for(int i=0;i<n;i++){
            int waterLevel=Math.min(leftmax[i],rightmax[i]);
            trappedWater +=waterLevel-arr[i];
        }
        return trappedWater;
    } 
}


