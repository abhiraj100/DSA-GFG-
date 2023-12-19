/*
Given a positive integer N, return the Nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
The elements can be large so return it modulo 109 + 7.

File:PascalTriangleAnimated2.gif

Example 1:

Input:
N = 4
Output: 
1 3 3 1
Explanation: 
4th row of pascal's triangle is 1 3 3 1.
Example 2:

Input:
N = 5
Output: 
1 4 6 4 1
Explanation: 
5th row of pascal's triangle is 1 4 6 4 1.
*/

class PascalTriangle {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
         ArrayList<Long> pre = new ArrayList<>();
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            ArrayList<Long> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == i | j == 0) {
                    current.add(1l);
                } else {
                    long num = (pre.get(j) + pre.get(j - 1)) % mod;
                    current.add(num);
                }
            }
            pre = current;
        }
        return pre;
    }
}
