/*
You are given two arrays A and B of unique elements of size N. Check if array B is a stack permutation of the array A or not.
Stack permutation means that array B can be created from array A using a stack and stack operations.

 

Example 1:

Input:
N = 3
A = {1,2,3}
B = {2,1,3}
Output:
1
Explanation:
1. push 1 from A to stack
2. push 2 from A to stack
3. pop 2 from stack to B
4. pop 1 from stack to B
5. push 3 from A to stack
6. pop 3 from stack to B
 

Example 2:

Input:
N = 3
A = {1,2,3}
B = {3,1,2}
Output:
0
Explanation:
Not Possible
*/

class Solution {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> perm = new Stack<>();
        
        // opidx will be used to track the idx 
        // of the element of op array that we 
        // are currently comparing
        int opidx = 0;
        for (int i = 0; i < op.length; i++) {
            perm.push(ip[i]);
            
            // now we need to check if the top of the stack
            // is equal to the element where the opidx is 
            // currently pointing then we need to pop the 
            // top element and we need to do this until we 
            // find the condition satisfied
            while (!perm.isEmpty() && perm.peek() == op[opidx]) {
                opidx++;
                perm.pop();
            }
        }
        
        // we have reached the end of the op array
        // and the stack is empty that means have 
        // reached the end
        if (opidx == n && perm.isEmpty()) return 1;
        else return 0;
    }
}