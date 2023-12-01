class  Solution
{
    void shuffleArray(long arr[], int n)
    {
        // Your code goes here
        for(int i=0;i<n/2;i++) {
            arr[i] = arr[i] << 10;
            arr[i] = arr[i] | arr[n/2+i];
        }
        
        int index = n-1;
        for(int i=n/2-1;i>=0;i--) {
            arr[index--] = arr[i] & (int)Math.pow(2,10) - 1;
            arr[index--] = arr[i] >> 10;
        }
    }
}