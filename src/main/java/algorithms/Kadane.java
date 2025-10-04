package algorithms;

public class Kadane {

    public static int[] maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            int ai = arr[i];

            if (currentSum < 0) {
                currentSum = ai;
                tempStart = i;
            } else {
                currentSum += ai;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[] { maxSum, start, end };
    }
}
