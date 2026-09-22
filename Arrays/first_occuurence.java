static int firstOccurrence(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == x) {
            ans = mid;
            high = mid - 1;
        }
        else if (arr[mid] < x) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }

    return ans;
}