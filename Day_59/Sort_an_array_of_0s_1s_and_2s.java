/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

*/


class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        Arrays.sort(a);
       
    }
}


/*
class Solution{
    public static void sort012(int a[], int n){
    // code here
    //             a={0,2,1,2,0}
    // output -> 0,0,1,2,2
    
        // Arrays.sort(a);
        // Using Dutch National Flag Algorithm
        
        int low = 0;
        int high = n-1;
        int mid = 0;
        
        while(mid<=high){
            switch(a[mid]){
                case 0:
                    swap(a,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a,mid,high);
                    high--;
                    break;
            }
        }
    }
        
        public static void swap(int a[], int i, int j){
            int temp = a[i];
            a[i]=a[j];
            a[j]=temp;
    
    } 
    
}
*/