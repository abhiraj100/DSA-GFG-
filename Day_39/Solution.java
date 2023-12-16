class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        
    Map<Integer, Integer> seen = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int b = k - num;

            if (seen.containsKey(b)) {
                count += seen.get(b);
            }

            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        return count;

    }
}