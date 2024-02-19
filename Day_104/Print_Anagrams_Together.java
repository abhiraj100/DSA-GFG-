/*
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

Note: The final output will be in lexicographic order.


Example 1:

Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output:
act cat tac 
god dog
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.
Example 2:

Input:
N = 3
words[] = {no,on,is}
Output: 
is
no on
Explanation:
There are 2 groups of
anagrams "is" makes group 1.
"no", "on" make group 2.
*/

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> ans= new ArrayList<>();
        for(String s:string_list){
            if(ans.isEmpty()){
                List<String> lst=new ArrayList<>();
                lst.add(s);
                ans.add(lst);
            }else{
                int k=0;
                for(int i=0;i<ans.size();i++){
                    char ch[]=ans.get(i).get(0).toCharArray();
                    Arrays.sort(ch);
                    String a=String.copyValueOf(ch);
                    char ch2[]=s.toCharArray();
                    Arrays.sort(ch2);
                    String b=String.copyValueOf(ch2);
                    if(a.equals(b)){
                        ans.get(i).add(s);
                        k=1;
                        break;
                    }
                }
                if(k==0){
                    List<String> lst=new ArrayList<>();
                    lst.add(s);
                    ans.add(lst); 
                }
            }
        }
       // System.out.println(ans);
        //Collections.sort(ans);
        return ans;
    }
}