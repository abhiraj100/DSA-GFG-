/*
Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating (in any direction) string 'a' by exactly 2 places.

Example 1:

Input:
a = amazon
b = azonam
Output: 
1
*/

class Rotation
{
    public static boolean isRotated(String str1, String str2)
    {
        if(str1.length()!=str2.length())
            return false;
            
        boolean b1 = true;
        
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!=str2.charAt((i+2)%str1.length()))
                b1 = false;
        }
        
        boolean b2 = true;
        
        for(int i=0;i<str1.length();i++)
        {
            if(str2.charAt(i)!=str1.charAt((i+2)%str1.length()))
                b2 = false;
        }
        
        return (b1 || b2);
    }
}
