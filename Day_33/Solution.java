class Solution { 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Your code goes here 
        Arrays.sort(arr);
        int dp[] = new int[N];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=N-1; i>=0; i--){
            if(dp[i]==-1){
                for(int j=i-1; j>=0; j--){
                if(arr[i]-arr[j]<K){
                    if(dp[j]==-1){
                        ans+=arr[i]+arr[j];
                        dp[j] = arr[i]+arr[j];
                        break;
                    }
                }
            }
            }
        }
        return ans;
    }
    
}