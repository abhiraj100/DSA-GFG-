/*
Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses and takes only a string S as its only argument.
Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.


For string 11211 the IP address possible are 
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1

Example 1:

Input:
S = 1111
Output: 1.1.1.1
Example 2:

Input:
S = 55
Output: -1

Your Task:

Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses or -1 if no such IP address could be generated through the input string S, the only argument to the function.

Expected Time Complexity: O(N * N * N)
Expected Auxiliary Space: O(N * N * N * N)

Constraints:
1<=N<=16
here, N = length of S.
S only contains digits(i.e. 0-9)
*/


class Solution {
    public ArrayList<String> genIp(String s) {
        if(s.length() >12)
        return new ArrayList<String>();
        

        ArrayList<String> ans = helpgenIp(0, 0, s);
        return ans;
    }
    public ArrayList<String> helpgenIp(int i, int count, String s){
        if(count > 2){
            if(isValid(s)){
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
            }
            else
            return new ArrayList<String>();
        }
         
         ArrayList<String> list = new ArrayList<String>();
         //changhing the string 
         if(i<s.length()){
         String first = s.substring(0,i);
         String second = s.substring(i);
         String aux = first+"."+second;
         list.addAll(helpgenIp(i+1, count+1, aux));
         
         list.addAll(helpgenIp(i+1, count, s));
         }
         return list;
         
    }
    
    public boolean isValid(String s) {
        if(s.endsWith("."))
        return false;

        String[] split = s.split("[.]");
        
        
        boolean ans = false;
        int val=0;
        
        if(split.length != 4)
        return false;
        
        for (String a : split)
        {
    
            if(a.isEmpty())
            return false;
            
            if((a.startsWith("0") && a.length()>1)|| (a.startsWith("00")&& a.length()>2) || a.startsWith("000"))
            return false;
            
            for(int j=0; j<a.length(); j++)
            {
                if(!(a.charAt(j)>=48 && a.charAt(j)<=57)){
                    return false;
                }
                
            }
            val = con(a);
            
            if(val>=0 && val<= 255)
            ans = true;
            else
            return false;
        }
        return ans;
    }
    public static int con(String a){
        int ans=0;
        for(int i=0; i<a.length(); i++)
        {
            ans = ans*10 +a.charAt(i)-'0';
        }
        return ans;
    }
}