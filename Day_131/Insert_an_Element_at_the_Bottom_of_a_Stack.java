/*
You are given a stack st of n integers and an element x. You have to insert x at the bottom of the given stack. 

Note: Everywhere in this problem, the bottommost element of the stack is shown first while priniting the stack.

Example 1:

Input:
n = 5
x = 2
st = {4,3,2,1,8}
Output:
{2,4,3,2,1,8}
Explanation:
After insertion of 2, the final stack will be {2,4,3,2,1,8}.
Example 2:

Input:
n = 3
x = 4
st = {5,3,1}
Output:
{4,5,3,1}
Explanation:
After insertion of 4, the final stack will be {4,5,3,1}.
Your Task:

You don't need to read input or print anything. Your task is to complete the function insertAtBottom() which takes a stack st and an integer x as inputs and returns the modified stack after insertion.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
0 <= x, elements of stack <= 109
*/

class Solution {
    public Stack<Integer> push1(Stack<Integer> st, Stack<Integer> st1){
        if (st.isEmpty()) 
        return st1; 
    
        int x = st.peek(); 
        st.pop(); 
        Stack<Integer> st3 = push1(st,st1); 
        st1.push(x);
        return st3;
    }
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> st1 = new Stack<Integer>();
        st1.add(x);
        
        return push1(st,st1);
        
    }
}