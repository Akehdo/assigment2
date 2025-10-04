package metrics;

public class KadaneMeasured {

    public static int[] maxSubArray(int[] arr, Metrics metrics) {
        final Metrics m = metrics;

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        if (m != null) {
            m.incArrayAccesses();
        }

        int maxSum = arr[0];
        if (m != null) {
            m.incAssignments();
        }

        int currentSum = arr[0];
        if (m != null) {
            m.incAssignments();
        }

        int start = 0;
        if (m != null) {
            m.incAssignments();
        }

        int end = 0;
        if (m != null) {
            m.incAssignments();
        }

        int tempStart = 0;
        if (m != null) {
            m.incAssignments();
        }

        for (int i = 1; i < arr.length; i++) {
            if (m != null) {
                m.incArrayAccesses();
            }

            int ai = arr[i];
            if (m != null) {
                m.incAssignments();
            }

            if (m != null) {
                m.incComparisons();
            }

            if (currentSum < 0) {
                currentSum = ai;
                if (m != null) {
                    m.incAssignments();
                }

                tempStart = i;
                if (m != null) {
                    m.incAssignments();
                }
            } else {
                currentSum += ai;
                if (m != null) {
                    m.incAssignments();
                }
            }

            if (m != null) {
                m.incComparisons();
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                if (m != null) {
                    m.incAssignments();
                }

                start = tempStart;
                if (m != null) {
                    m.incAssignments();
                }

                end = i;
                if (m != null) {
                    m.incAssignments();
                }
            }
        }

        if (m != null) {
            m.incAllocations();
        }

        return new int[] { maxSum, start, end };
    }
}
