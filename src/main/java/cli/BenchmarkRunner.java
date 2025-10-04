package cli;


import metrics.KadaneMeasured;
import metrics.Metrics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = new int[] { 100, 1_000, 10_000, 100_000 };
        int trialsPerSize = 5;
        int minValue = -1000;
        int maxValue = 1000;

        File outDir = new File("target/bench");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        File csv = new File(outDir, "kadane.csv");

        try (FileWriter fw = new FileWriter(csv)) {
            fw.write("size,trial,maxSum,start,end,ns,comparisons,assignments,arrayAccesses,allocations\n");

            Random rnd = new Random(42);
            Metrics metrics = new Metrics();

            for (int size : sizes) {
                for (int trial = 1; trial <= trialsPerSize; trial++) {
                    int[] arr = generateArray(size, minValue, maxValue, rnd);

                    metrics.reset();

                    long t0 = System.nanoTime();
                    int[] res = KadaneMeasured.maxSubArray(arr, metrics);
                    long t1 = System.nanoTime();

                    long dt = t1 - t0;

                    fw.write(
                            size + "," +
                                    trial + "," +
                                    res[0] + "," +
                                    res[1] + "," +
                                    res[2] + "," +
                                    dt + "," +
                                    metrics.getComparisons() + "," +
                                    metrics.getAssignments() + "," +
                                    metrics.getArrayAccesses() + "," +
                                    metrics.getAllocations() +
                                    "\n"
                    );
                    fw.flush();
                }
            }

            System.out.println("CSV saved to: " + csv.getPath());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static int[] generateArray(int n, int minValue, int maxValue, Random rnd) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = minValue + rnd.nextInt(maxValue - minValue + 1);
        }
        return a;
    }
}
