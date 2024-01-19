/*
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
*/

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        int ind = -1;
        
        for(int i = N - 2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }
        
        if(ind == -1){
            reverseArray(arr, 0, N - 1);
        }else{
            
            for(int i = N - 1; i >= 0; i--){
                if(arr[i] > arr[ind]){
                    swapElements(arr, i , ind);
                    break;
                }
            }
            
            reverseArray(arr, ind + 1, N - 1);
        }
        
        
        List<Integer> al = new ArrayList<>();
        
        for(int i : arr){
            al.add(i);
        }
        
        return al;
    }
    
    public static void reverseArray(int[] arr, int start, int end){
        while(start < end){
            swapElements(arr, start, end);
            start++;
            end--;
        }
    }
    
    public static void swapElements(int[] arr, int i, int ind){
        int temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
}
