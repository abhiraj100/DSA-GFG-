/*
Given a matrix of size N x N. Print the elements of the matrix in the snake like pattern depicted below.

Example 1:

Input:
N = 3 
matrix[][] = {{45, 48, 54},
             {21, 89, 87}
             {70, 78, 15}}
Output: 
45 48 54 87 89 21 70 78 15 
Explanation:
Matrix is as below:
45 48 54
21 89 87
70 78 15
Printing it in snake pattern will lead to 
the output as 45 48 54 87 89 21 70 78 15.
Example 2:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 
1 2 4 3
Explanation:
Matrix is as below:
1 2 
3 4
Printing it in snake pattern will 
give output as 1 2 4 3.
*/

class Matrix
{
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
         ArrayList<Integer> sn = new ArrayList<>();
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    sn.add(matrix[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    sn.add(matrix[i][j]);
                }
            }
        }

        return sn;
    }
}
//
