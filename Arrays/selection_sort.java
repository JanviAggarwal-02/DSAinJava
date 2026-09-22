public import java.util.*;

class Main {

    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];

            arr[i] = arr[min];

            arr[min] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 4, 1, 9, 3};

        selectionSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
} {
    
}
