/*
Given an array Arr of size N such that each element is from the range 0 to 9. Find the minimum possible sum of two numbers formed using the elements of the array. All digits in the given array must be used to form the two numbers.


Example 1:

Input:
N = 6
Arr[] = {6, 8, 4, 5, 2, 3}
Output: 604
Explanation: The minimum sum is formed 
by numbers 358 and 246.

Example 2:

Input:
N = 5
Arr[] = {5, 3, 0, 7, 4}
Output: 82
Explanation: The minimum sum is 
formed by numbers 35 and 047.
*/

class Solution {
    String solve(int[] arr, int n) {
        // code here
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(int i=0;i<n;i++){
            if(i%2!=0){
                a.append(""+arr[i]);
            }else{
                b.append(""+arr[i]);
            }
        }
        String sum = sum(a.reverse(), b.reverse());
        
        return sum;
    }
    
    String sum(StringBuilder a, StringBuilder b){
        int len = a.length() > b.length() ? a.length() : b.length();
        int carry = 0;
        StringBuilder temp = new StringBuilder();
        int i=0,j = 0;
        while(i<len || carry!=0){
            int d1 = i>=a.length() ? 0 : Character.getNumericValue(a.charAt(i));
            int d2 = i>=b.length() ? 0 : Character.getNumericValue(b.charAt(i));
            int sum = d1+d2+carry;
            carry = sum/10;
            sum = sum%10;
            temp.append(""+sum);
            ++i;
        }
        temp.reverse();
      
        //trim leading zeros
        i=0;
        while(i<temp.length() && temp.charAt(i)=='0'){
            i++;
        }
        if(i==temp.length())return "0"; 
        return temp.toString().substring(i);
    }
}