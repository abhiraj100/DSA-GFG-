class Solution
{
    int mod = 1000000007; //constant value for modulo operation
    int ans = 0; //variable to store the final answer
    HashMap<Integer,Integer> mp = new HashMap<>(); //HashMap to store intermediate results
    
    //utility function to calculate the sum of paths with given sum
    public void sumK_util(Node root, int sum, int cur)
    {
        //base case: if root is null, return
        if(root == null)
            return;
        
        //check if cur+root.data - sum exists in the HashMap
        //if yes, add its frequency to the answer
        ans = (ans + (mp.getOrDefault(cur + root.data - sum,0))%mod)%mod;
        
        //check if cur+root.data is equal to sum
        //if yes, increment the answer by 1
        if((cur + root.data) == sum)
            ans = (ans+1)%mod;
        
        //update the frequency of cur+root.data in the HashMap
        mp.put(cur + root.data, (mp.getOrDefault(cur + root.data,0)+1)%mod);
        
        //recursively call the function for left and right subtrees
        sumK_util(root.left, sum, cur+root.data);
        sumK_util(root.right, sum, cur+root.data);
        
        //decrement the frequency of cur+root.data in the HashMap
        mp.put(cur + root.data, ((mp.getOrDefault(cur + root.data,0)-1) + mod)%mod);
    }
    public int sumK(Node root,int k)
    {
         sumK_util(root, k, 0);
        
        //clear the HashMap after the calculations
        mp.clear();
        
        //store the answer in a temporary variable
        int temp = ans;
        ans = 0; //reset the answer variable
        
        //return the temporary variable as the final answer
        return temp;
    }
}