class Solution {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int k = 0;
        
        int[] result = new int[n + m];
        
        for (int i = 0; i < n; i++) {
            result[k++] = a[i];
        }
        
        for (int i = 0; i < m; i++) {
            result[k++] = b[i];
        }
        
        // Build heap starting from the last non-leaf node
        for (int i = (result.length / 2) - 1; i >= 0; i--) {
            heapify(result, result.length, i);
        }
        
        return result;
    }

    // Heapify function to maintain heap property
    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[largest] < arr[l]) {
            largest = l;
        }

        if (r < n && arr[largest] < arr[r]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }
}
