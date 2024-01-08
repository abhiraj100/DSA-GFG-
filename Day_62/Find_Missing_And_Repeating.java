/*

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.

Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.

*/

class Solve {
    int[] findTwoElement(int arr[], int n) {
    int repeating = 0, missing = 0;

    for (int i = 0; i < n; i++) {
        int index = Math.abs(arr[i]) - 1;
        if (arr[index] > 0) {
            arr[index] = -arr[index];
        } else {
            repeating = Math.abs(arr[i]);
        }
    }

    for (int i = 0; i < n; i++) {
        if (arr[i] > 0) {
            missing = i + 1;
            break;
        }
    }

    return new int[]{repeating, missing};
 }
}