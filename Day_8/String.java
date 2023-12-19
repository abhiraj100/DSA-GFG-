/*
Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.

Example 1:

Input:
str1 = "gfg", str2 = "ggg"
Output: "gfg"
*/    

class String {
    static String betterString(String str1, String str2) {
        int mod = 1000000007;
        int n = str1.length();

        int[] lastPos1 = new int[256];
        int[] lastPos2 = new int[256];

        Arrays.fill(lastPos1, -1);
        Arrays.fill(lastPos2, -1);
        
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        dp1[0] = 1;
        dp2[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp1[i] = (2 * dp1[i - 1]) % mod;
            if (lastPos1[str1.charAt(i - 1)] != -1) {
                dp1[i] = (dp1[i] - dp1[lastPos1[str1.charAt(i - 1)] - 1] + mod) % mod;
            }
            lastPos1[str1.charAt(i - 1)] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp2[i] = (2 * dp2[i - 1]) % mod;
            if (lastPos2[str2.charAt(i - 1)] != -1) {
                dp2[i] = (dp2[i] - dp2[lastPos2[str2.charAt(i - 1)] - 1] + mod) % mod;
            }
            lastPos2[str2.charAt(i - 1)] = i;
        }

        if (dp1[n] >= dp2[n]) {
            return str1;
        } else {
            return str2;
        }
    }
}
