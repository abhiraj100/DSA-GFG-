/*
Given two integers N and K, the task is to find the string S of minimum length such that it contains all possible strings of size N as a substring. The characters of the string should be from integers ranging from 0 to K-1.  

Example 1:

Input:
N = 2, K = 2
Output: 
00110
*/    

class PossibleString{
    public String findString(int n, int k){
            StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ans.append('0');
        }

        k--;

        HashSet<String> visited = new HashSet<>();
        visited.add(ans.toString());

        while (visited.size() < Math.pow((k + 1), n)) {
            String previous = ans.substring(ans.length() - n + 1);

            for (int i = k; i >= 0; i--) {
                String currStr = previous + (char) (i + '0');

                if (!visited.contains(currStr)) {
                    visited.add(currStr);
                    ans.append((char) (i + '0'));
                    break;
                }
            }
        }

        return ans.toString();
    }
}
