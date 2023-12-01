class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
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