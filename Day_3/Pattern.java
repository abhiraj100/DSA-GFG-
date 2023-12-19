/*
Given a pattern containing only I's and D's. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can't repeat.

Example 1:

Input:
D
Output:
21
*/

class Pattern{
    public static String printMinNumberForPattern(String pattern) {
        int n = pattern.length() + 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (pattern.charAt(i) == 'D') {
                int start = i;
                while (i < n - 1 && pattern.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, start, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String pattern = "IDID";
        String output = printMinNumberForPattern(pattern);

        System.out.println(output);
    }
}
