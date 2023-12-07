class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
         Map<Integer,Integer> map = new HashMap<>();
        
        int val = n/k;
        int count=0;
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> temp : map.entrySet())
        {
            if(temp.getValue()>val)
            count++;
        }
        
        return count;
    }
}
