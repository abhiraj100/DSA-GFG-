/*
Given a text and a pattern, the task is to check if the pattern exists in the text or not.

Example 1:

Input: text = "geeksforgeeks"
       pat = "geek"
Output: 1
Explanation: "geek" exists in
"geeksforgeeks"
Example 2:

Input: text = "geeksforgeeks"
pat = "gfg"
Output: 0
Explanation: "gfg" does not exists in
"geeksforgeeks"
Your Task:  
You don't need to read input or print anything. Your task is to complete the function search() which takes the string two strings as inputs and returns 1 if the pattern is found, otherwise 0.

Expected Time Complexity: O(|text| + |pat|)
Expected Auxiliary Space: O(|text| + |pat|)

Constraints:
1 ≤ |text|, |pat| ≤ 105
Both of the string contains lower case English alphabets
*/

class Solution {
    int search(String txt, String pat) {
         int res=-1;        
        
         int n=txt.length();
        int m=pat.length();
        
        for(int i=0;i<=n-m;i++){
            
            
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
                
            }
            if(j==m){
            res=i+1;
            
            break;
            }
            
        }
        
        if(res!=-1)
        return 1;
        return 0;
    }
};