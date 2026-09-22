import java.util.*;
class Main {
    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            // Sort left half
            mergeSort(arr, low, mid);
            // Sort right half
            mergeSort(arr, mid + 1, high);
            // Merge both halves
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        // Compare both halves
        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {

                temp[k] = arr[i];
                i++;
            }

            else {

                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // Remaining elements of left half
        while (i <= mid) {

            temp[k] = arr[i];

            i++;
            k++;
        }

        // Remaining elements of right half
        while (j <= high) {

            temp[k] = arr[j];

            j++;
            k++;
        }

        // Copy temp back to original array
        for (int x = 0; x < temp.length; x++) {

            arr[low + x] = temp[x];
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 1, 3, 7, 6};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}