/*
Given a String S, Find all possible Palindromic partitions of the given String.
 

Example 1:

Input:
S = "geeks"
Output:
g e e k s
g ee k s
Explanation:
All possible palindromic partitions
are printed.
Example 2:

Input:
S = "madam"
Output:
m a d a m
m ada m
madam

Your Task:
You don't need to read input or print anything. Your task is to complete the function allPalindromicPerms() which takes a String S as input parameter and returns a list of lists denoting all the possible palindromic partitions in the order of their appearance in the original string.

 

Expected Time Complexity: O(N*2N)
Expected Auxiliary Space: O(N2), where N is the length of the String

 

Constraints:
1 <= |S| <= 20
*/

class Solution {

    public boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentPartition = new ArrayList<>();
        Solution solution = new Solution();  // Create an instance of Solution
        partition(result, S, 0, currentPartition, solution);
        return result;
    }

    private static void partition(
        ArrayList<ArrayList<String>> result, String s, int ind, ArrayList<String> currentPartition, Solution solution
    ) {
        if (ind == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        String temp = "";

        for (int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            if (solution.checkPalindrome(temp)) {
                currentPartition.add(temp);
                partition(result, s, i + 1, currentPartition, solution);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}