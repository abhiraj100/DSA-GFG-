/*
You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Example 1:

Input:
geeksforgeeks
forgeeksgeeks
Output: 
1
*/    
class String
{
    public static boolean areRotations(String s1, String s2 )
    {
        if (s1.length() != s2.length()) {
            return false;
        }

        String concatenated = s1 + s1;

        return concatenated.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        if (areRotations(s1, s2)) {
            System.out.println(s2 + " is a rotated version of " + s1);
        } else {
            System.out.println(s2 + " is not a rotated version of " + s1);
        }
    }
    
}
