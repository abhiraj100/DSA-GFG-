/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

 

Example 1:

Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
 
Example 2:
Input : 
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0 
*/

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> cur=new ArrayList<>();
        Queue<Long> q=new LinkedList<>();
        
       
        for (int i=0;i<K;i++){
            if (A[i]<0){
                q.add(A[i]);
            }
        }
        int l=0;
        int r=K-1;
   

        while (r<N){
            if (!q.isEmpty()) cur.add(q.peek());
            else cur.add((long)0);
            if (!q.isEmpty() && q.peek()==A[l]) q.poll();
            r++;
            l++;
            if (r<N && A[r]<0) q.add(A[r]);
        
            
        }
        long[] res=new long[cur.size()];
        for (int i=0;i<cur.size();i++){
            res[i]=cur.get(i);
        }
         return res;
        
    }
}