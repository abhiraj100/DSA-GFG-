class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        int buyIndex=-1;
        int sellIndex=-1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                if(buyIndex==-1)
                    buyIndex=i-1;
                sellIndex=i;
                if(i==n-1)
                    addToList(buyIndex, sellIndex, list);
            }
            else if(arr[i]<arr[i-1]){
                addToList(buyIndex, sellIndex, list);
                buyIndex=-1;
            }
            
        }
        return list;
    }
    public static void addToList(int buyIndex, int sellIndex,  ArrayList<ArrayList<Integer>> list){
        if(buyIndex!=-1){
            ArrayList<Integer> insideList=new ArrayList<>();
            insideList.add(buyIndex);
            insideList.add(sellIndex);
            list.add(insideList);        
        }
    }             
}
