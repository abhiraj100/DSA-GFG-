class Solution {
    public static long maximizeSum(long a[], int n, int k) {
        Arrays.sort(a);
        int i = 0;
        while (k > 0 && i < n && a[i] < 0) {
            a[i] = -a[i];
            k--;
            i++;
        }
        if (k % 2 == 1) {
            Arrays.sort(a);
            a[0] = -a[0];
        }
        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += a[j];
        }
        return sum;
    }
}