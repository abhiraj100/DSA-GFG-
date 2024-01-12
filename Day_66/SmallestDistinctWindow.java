/*
Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.

 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
*/

class Solution {
    public int findSubString( String str) {
        HashSet<Character>hs=new HashSet<>();
        for(int i=0;i<str.length();i++){
            hs.add(str.charAt(i));
        }
        HashMap<Character,Integer>hm=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0,j=0;i<str.length();i++){
            char ch=str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()==hs.size()&&j<str.length()){
                char c=str.charAt(j);
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)<=0){
                    hm.remove(c);
                    ans=Math.min(ans,i-j+1);
                }
                j++;
            }
        }
        return ans;
    }
}