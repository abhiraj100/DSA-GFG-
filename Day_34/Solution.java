class Solution {
    String removeDuplicates(String str) {
        // code here
        StringBuilder ans = new StringBuilder();
        HashSet<Character> st = new HashSet<>();
        st.add(str.charAt(0));
        ans.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(!st.contains(str.charAt(i))){
                ans.append(str.charAt(i));
            }
            st.add(str.charAt(i));
        }
        return ans.toString();
    }
}
