package metrics;

public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long allocations = 0;
    private long assignments = 0;

    public void incComparisons() {
        comparisons++;
    }

    public void incSwaps() {
        swaps++;
    }

    public void incArrayAccesses() {
        arrayAccesses++;
    }

    public void incAllocations() {
        allocations++;
    }

    public void incAssignments() {
        assignments++;
    }

    public long getComparisons() {
        return comparisons;
    }
    public long getSwaps() {
        return swaps;
    }
    public long getArrayAccesses() {
        return arrayAccesses;
    }
    public long getAllocations() {
        return allocations;
    }
    public long getAssignments() {
        return assignments;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        allocations = 0;
        assignments = 0;
    }

    @Override
    public String toString() {
        return "comparisons=" + comparisons
                + ", swaps=" + swaps
                + ", assignments=" + assignments
                + ", arrayAccesses=" + arrayAccesses
                + ", allocations=" + allocations;
    }
}
