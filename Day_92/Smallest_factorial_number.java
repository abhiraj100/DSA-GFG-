/*
Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

Example 1:

Input:
n = 1
Output: 5
Explanation : 5! = 120 which has at
least 1 trailing 0.
Example 2:

Input:
n = 6
Output: 25
Explanation : 25! has at least
6 trailing 0.

User Task:
Complete the function findNum() which takes an integer N as input parameters, and returns the answer.
*/

class Solution
{
    int findNum(int n)
    {
          for(int i=0;i<1e5;i++)
            {
                int x=i/5 + i/25 + i/125 +i/625 + i/3125 + i/15625;
                if(x>=n)return i;
            }
            return 0;
    }
    
}