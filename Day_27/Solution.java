class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here 
        int smaller=0;
        int between=0;
        int larger=array.length-1;
        while(between<=larger){
            if(array[between]<a){
                swap(array,smaller,between);
                smaller++;
                between++;
            }
            else if(array[between]>=a && array[between]<=b) between++;
            else{
                swap(array,larger,between);
                larger--;
            }
        }
    }
    
    public void swap(int array[], int a, int b){
        int temp=array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
