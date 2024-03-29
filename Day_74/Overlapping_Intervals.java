/*
Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

Example 1:

Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
Example 2:

Input:
Intervals = {{6,8},{1,9},{2,4},{4,7}}
Output: {{1, 9}}
*/


class Solution
{
    public int[][] overlappedInterval(int[][] Interval)
    {
        Arrays.sort(Interval, Comparator.comparingInt(a -> a[0]));
        int n = Interval.length;
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int start = Interval[i][0];
            int end = Interval[i][1];
            if(ans.size()>0 && end <= ans.get(ans.size()-1)[1])
            continue;
            for(int j=i+1;j<n;j++)
            {
                if(Interval[j][0]<=end)
                end = Math.max(end,Interval[j][1]);
                else
                break;
            }
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}