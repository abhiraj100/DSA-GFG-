/*
You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}
Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.
*/

class Solution 
{
    public static int numberOfStudent(int pages[],int n,int capacity){
        int student_count = 1;
        int curr_capacity = pages[0];
        
        for(int i=1;i<n;i++){
            curr_capacity+=pages[i];
            if(curr_capacity>capacity){
                student_count+=1;
                
                curr_capacity = pages[i];
                
            }
        }
        
        return student_count;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]pages,int n,int studs)
    {
        int start = Arrays.stream(pages).max().orElseThrow();
        int end = Arrays.stream(pages).sum();
        if(n<studs){
            return -1;
        }
        if(numberOfStudent(pages,n,start)<=studs){
            return start;
        }

        while(start<end){
            if(start==end-1){
                break;
            }

            int mid = start + (end-start)/2;
            int curr_student = numberOfStudent(pages,n,mid);
            if(curr_student<=studs){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        return start+1;
    }
};