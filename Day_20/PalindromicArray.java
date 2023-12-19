/*
Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

Example 1:

Input:
5
111 222 333 444 555

Output:
1
*/

class PalindromicArray
{
	public static int palinArray(int[] a, int n)
    {
        for (int num : a) {
            int original = num;
            int reversed = 0;
            int remainder;

            while (num > 0) {
                remainder = num % 10;
                reversed = reversed * 10 + remainder;
                num = num / 10;
            }

            if (original != reversed) {
                return 0; 
            }
        }
        return 1; 
    }
}
