/*
Given a string S. The task is to print all unique permutations of the given string that may contain dulplicates in lexicographically sorted order. 

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function find_permutation() which takes the string S as input parameter and returns a vector of string in lexicographical order.

Expected Time Complexity: O(n! * n)
Expected Space Complexity: O(n! * n)

Constraints:
1 <= length of string <= 5
*/

class Solution {
    public List<String> find_permutation(String S) {
        Set<String> temp=new HashSet<>();
        ArrayList<String> ans=new ArrayList<>();
        permutation("",S,temp);
        ans.addAll(temp);
        Collections.sort(ans);
        return ans;
    }
    public static void permutation(String p,String up,Set<String> temp)
    {
        if(up.isEmpty())
        {
            temp.add(p);
            return;
        }
        char c=up.charAt(0);
        for(int i=0;i<=p.length();i++)
        {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutation(f+c+s,up.substring(1),temp);
        }
    }
}