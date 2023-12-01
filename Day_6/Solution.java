class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
           int[][] scs = new int[m + 1][n + 1];
        
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    scs[i][j] = j;
                } else if (j == 0) {
                    scs[i][j] = i;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    scs[i][j] = 1 + scs[i - 1][j - 1];
                } else {
                    scs[i][j] = 1 + Math.min(scs[i - 1][j], scs[i][j - 1]);
                }
            }
        }
        
        return scs[m][n];
    }
}