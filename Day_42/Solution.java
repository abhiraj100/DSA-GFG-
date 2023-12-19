class Solution { 
    int minSubset(int[] Arr,int N) { 
        Arrays.sort(Arr);
        long ans=0;
        for(int i=0;i<N;i++) ans+=Arr[i];
        
        int c=0; long dum=0;
        for(int j=N-1;j>0;j--) {ans-=Arr[j];
        dum+=Arr[j];
        c++;
            if(dum>ans) return c; 
        }
        return 1;
        
    }
}