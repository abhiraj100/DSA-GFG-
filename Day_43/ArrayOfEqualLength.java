/*
You are given two arrays A and B of equal length N. Your task is to pair each element of array A to an element in array B, such that the sum of the absolute differences of all the pairs is minimum.

Example 1:

Input:
N = 4
A = {4,1,8,7}
B = {2,3,6,5}
Output:
6
Explanation:
If we take the pairings as (1,2), (4,3),
(7,5), and (8,6), the sum will be S =
|1 - 2| + |4 - 3| + |7 - 5| + |8 - 6| = 6.
It can be shown that this is the minimum sum we can get.
*/

class ArrayOfEqualLength { 
    long findMinSum(int[] A,int[] B,int N) { 
        long sum=0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0;i<N;i++){
            sum+=Math.abs(A[i]-B[i]);
        }
        return sum;
    }
}
