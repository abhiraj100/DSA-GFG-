class Solution
{
    static int majorityElement(int a[], int size)
    {
        HashMap<Integer, Integer> track = new HashMap<>();
        int ans = -1;
        
        for(int i=0; i<a.length; i++) {
            if(track.containsKey(a[i])) {
                track.put(a[i], track.get(a[i]) + 1);
            } else {
                track.put(a[i], 1);
            }
        }
        for(Integer key : track.keySet()) {
            if(track.get(key) > size/2) {
                ans = key;
            }
        }
        return ans;
    }
}