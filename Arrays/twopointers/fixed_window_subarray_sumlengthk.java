import java.util.*;

class Main {

    static int maxSum(int[] arr, int k) {

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // Slide window
        for (int i = k; i < arr.length; i++) {

            sum += arr[i];

            sum -= arr[i - k];

            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};

        int k = 3;

        int ans = maxSum(arr, k);

        System.out.println("Maximum sum = " + ans);
    }
}