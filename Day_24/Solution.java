class Compute {
    
    public void rotate(int arr[], int n)
    {
        int x=arr[arr.length-1];
        for (int i=arr.length-1; i>0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0]=x;
    }
}