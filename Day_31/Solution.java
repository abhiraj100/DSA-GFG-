class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
         Arrays.sort(arr,(i1,i2)->{
        
            return Integer.bitCount(i2)-Integer.bitCount(i1);
        });
    } 
}
