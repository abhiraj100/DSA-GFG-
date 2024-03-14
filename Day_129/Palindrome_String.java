/*
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Length of S<= 2*105
*/

class Solution {
    int isPalindrome(String S) {
    StringBuilder str = new StringBuilder();
     Stack<Character> s1 = new Stack<>();
     for(int i =0;i<S.length();i++){
         s1.push(S.charAt(i));
     }
     while(!s1.isEmpty()){
         str.append(s1.pop());
     }
     if(str.toString().equals(S)){
         return 1;
     }
     else{
         return 0;
     }
      
    }
};