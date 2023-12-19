/*
Given a binary tree and an integer K. Find the number of paths in the tree which have their sum equal to K.
A path may start from any node and end at any node in the downward direction.

Example 1:

Input:      
Tree = 
          1                               
        /   \                          
       2     3
K = 3
Output: 
2
*/

class BinaryTree
{
    int mod = 1000000007; //constant value for modulo operation
    int ans = 0; //variable to store the final answer
    HashMap<Integer,Integer> mp = new HashMap<>(); //HashMap to store intermediate results
    
    public void sumK_util(Node root, int sum, int cur)
    {
        if(root == null)
            return;
        
        ans = (ans + (mp.getOrDefault(cur + root.data - sum,0))%mod)%mod;
        
        if((cur + root.data) == sum)
            ans = (ans+1)%mod;
        
        mp.put(cur + root.data, (mp.getOrDefault(cur + root.data,0)+1)%mod);
        
        sumK_util(root.left, sum, cur+root.data);
        sumK_util(root.right, sum, cur+root.data);
        
        mp.put(cur + root.data, ((mp.getOrDefault(cur + root.data,0)-1) + mod)%mod);
    }
    public int sumK(Node root,int k)
    {
         sumK_util(root, k, 0);
        
        mp.clear();
        
        int temp = ans;
        ans = 0; //reset the answer variable
        
        return temp;
    }
}
