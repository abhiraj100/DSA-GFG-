class Solution {
    void rearrange(int arr[], int n) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        int i = 0;
        while (i < n) {
            if (!pos.isEmpty()) {
                arr[i] = pos.poll();
                i++;
            }

            if (i < n && !neg.isEmpty()) {
                arr[i] = neg.poll();
                i++;
            }
        }
    }
}