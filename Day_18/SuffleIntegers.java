/*
Given an array arr of n elements in the following format {a1, a2, a3, a4, ... , an/2, b1, b2, b3, b4, ... , bn/2}, the task is shuffle the array to {a1, b1, a2, b2, a3, b3, ... , an/2, bn/2} without using extra space.
Note that n is even.

Example 1:

Input: 
n = 4, arr = {1, 2, 9, 15}
Output:  
1 9 2 15
Explanation: 
a1=1, a2=2, b1=9, b2=15. So the final array will be: a1, b1, a2, b2 = {1,9,2,15}.
Example 2:

Input: 
n = 6 arr = {1, 2, 3, 4, 5, 6} 
Output: 
1 4 2 5 3 6
*/

class  SuffleIntegers
{
    void shuffleArray(long arr[], int n)
    {
        for(int i=0;i<n/2;i++) {
            arr[i] = arr[i] << 10;
            arr[i] = arr[i] | arr[n/2+i];
        }
        
        int index = n-1;
        for(int i=n/2-1;i>=0;i--) {
            arr[index--] = arr[i] & (int)Math.pow(2,10) - 1;
            arr[index--] = arr[i] >> 10;
        }
    }
}
