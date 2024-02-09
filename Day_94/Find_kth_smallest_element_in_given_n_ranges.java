/*
Given n ranges of the form [p, q] which denotes all the numbers in the range [p, p + 1, p + 2,...q].  Given another integer q denoting the number of queries. The task is to return the kth smallest element for each query (assume k>1) after combining all the ranges.
In case the kth smallest element doesn't exist return -1. 

Example 1:

Input:
n = 2, q = 3
range[] = {{1, 4}, {6, 8}}
queries[] = {2, 6, 10}
Output: 
2 7 -1
Explanation: 
After combining the given ranges, 
the numbers become 1 2 3 4 6 7 8. As here 2nd 
element is 2, so we print 2. As 6th element is 
7, so we print 7 and as 10th element doesn't 
exist, so weprint -1.
Example 2:

Input:
n = 2, q = 2
range[] = {{2, 6}, {5, 7}} 
queries[] = {5, 8}
Output: 
6 -1
Explantion: 
After combining the ranges, we'll take Union of 
range= {2,3,4,5,6,7}, here  5th smallest number 
will be 6 and 8th smallest number does not exists.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthSmallestNum() which takes a n * 2 array denoting the ranges and an array denoting the queries.
*/

class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        Arrays.sort(range, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int start = range[0][0];
        int end = range[0][1];

        for (int i = 1; i < range.length; i++) {
            if (end >= range[i][0]) {
                end = Math.max(end, range[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = range[i][0];
                end = range[i][1];
            }
        }
        list.add(new int[]{start, end});

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            for (int j = 0; j < list.size(); j++) {
                int s = list.get(j)[0];
                int e = list.get(j)[1];
                int curr = e - s + 1;
                if (curr >= k) {
                    res.add(s + k - 1);
                    k = k - curr;
                    break;
                }
                k = k - curr;
            }
            if (k > 0) {
                res.add(-1);
            }
        }
        return res;
    }
}