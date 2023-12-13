class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
          int st=0,sum=0;
        int len=n+1;
        for(int i=0;i<n;i++){
            sum+=a[i];
              
            
            if(sum > x)
            {
                while(sum > x) 
                    sum -= a[st++];
                len = Math.min(len, i-st+2);

            }
            else if (len!=n+1)
                sum -= a[st++];
        }
        len = len==n+1?0:len;
        return len;
    }
}