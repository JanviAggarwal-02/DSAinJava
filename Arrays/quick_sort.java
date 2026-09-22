import java.util.*;
class Main {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            // Left part
            quickSort(arr, low, pivotIndex - 1);
            // Right part
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 1, 3, 7, 6};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}