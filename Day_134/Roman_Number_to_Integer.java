/*
Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5
Example 2:

Input:
s = III 
Output: 3
Your Task:
Complete the function romanToDecimal() which takes a string as input parameter and returns the equivalent decimal number. 

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999
*/

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        int result = getValue(str.charAt(str.length() -1));
        for(int i = str.length() -2; i >=0 ; i--){
            
            if(getValue(str.charAt(i)) < getValue(str.charAt(i + 1))){
                 result -= getValue(str.charAt(i));
            }
            else{
                 result += getValue(str.charAt(i));
            }
        }
        return result;
    }
    
    public int getValue(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}

