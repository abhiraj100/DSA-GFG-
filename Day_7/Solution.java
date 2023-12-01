
class Solution
{
    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here
         // Check if lengths of both strings are the same
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s1 with itself
        String concatenated = s1 + s1;

        // Check if s2 is a substring of the concatenated string
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