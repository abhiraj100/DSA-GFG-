/*
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1

*/

class SquareMatrixCel
{ 
    int celebrity(int M[][], int n){
      Stack<Integer> pc = new Stack<>();

        for (int i = 0; i < n; i++) {
            pc.push(i);
        }

        while (pc.size() >= 2) {
            int person1 = pc.pop();
            int person2 = pc.pop();

            if (M[person1][person2] == 1) {
                pc.push(person2);
            } else {
                pc.push(person1);
            }
        }

        int candidate = pc.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1; 
            }
        }

        return candidate;
    }
}