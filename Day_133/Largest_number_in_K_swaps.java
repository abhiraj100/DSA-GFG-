/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10
*/

class Solution{
    
    static String ans;
    
    static void bigBoy(String res,int counter,int pos){
       
        if(res.compareTo(ans)>0){
            ans=res;
        }
        
        if(counter>0){
            int n=res.length();
            for(int i=pos;i<n;i++){
               for(int j=i+1;j<n;j++){
                   if(res.charAt(j)>res.charAt(i)){  //BackTracking
                       bigBoy( swap(res,i,j) , counter-1 , i+1 );
                   }
               }
            }
        }
        
    }
    
    static String swap(String str, int i, int j){
        
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
        
    }
    
    public static String findMaximumNum(String str, int k){
        
        ans=str;
        String res=new String(str);
        bigBoy(res,k,0);
        
        return ans;
        
    }
    
}