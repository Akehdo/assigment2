package algorithms;

import metrics.Metrics;

public class KadaneOptimized {

    public static int[] maxSubArray(int[] arr) {
        return maxSubArray(arr, null);
    }

    public static int[] maxSubArray(int[] arr, Metrics metrics) {
        final Metrics m = metrics;
        final boolean track = (m != null);

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        if (track) {
            m.incArrayAccesses();
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        if (track) {
            m.incAssignments();
            m.incAssignments();
            m.incAssignments();
            m.incAssignments();
            m.incAssignments();
        }

        for (int i = 1, n = arr.length; i < n; i++) {
            if (track) {
                m.incArrayAccesses();
            }

            final int ai = arr[i];

            if (track) {
                m.incAssignments();
                m.incComparisons();
            }

            if (currentSum < 0) {
                currentSum = ai;
                tempStart = i;

                if (track) {
                    m.incAssignments();
                    m.incAssignments();
                }
            } else {
                currentSum += ai;

                if (track) {
                    m.incAssignments();
                }
            }

            if (track) {
                m.incComparisons();
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;

                if (track) {
                    m.incAssignments();
                    m.incAssignments();
                    m.incAssignments();
                }
            }
        }

        if (track) {
            m.incAllocations();
        }

        return new int[] { maxSum, start, end };
    }
}
