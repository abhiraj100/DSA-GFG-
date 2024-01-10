/*
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-negative numbers.
(Maintain the order of all -ve and non-negative numbers as given in the original array).

Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 

Example 2:

Input:
N = 4
Arr[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 1, 0.
*/

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        int pointer1=0;
        for(int pointer2=0;pointer2<n;pointer2++){
            
            if(a[pointer2]<0){
                if(pointer1 != pointer2){
                    int temp=a[pointer2];
                    for(int i=pointer2;i>pointer1;i--){
                        a[i]=a[i-1];
                    }
                    a[pointer1]=temp;
                }
                pointer1++;
            }
        }
    }
}

