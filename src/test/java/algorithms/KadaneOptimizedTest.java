package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KadaneOptimizedTest {

    @Test
    void testClassicCase() {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] result = KadaneOptimized.maxSubArray(arr);
        assertArrayEquals(new int[] { 6, 3, 6 }, result);
    }

    @Test
    void testAllNegative() {
        int[] arr = new int[] { -5, -2, -8, -1 };
        int[] result = KadaneOptimized.maxSubArray(arr);
        assertArrayEquals(new int[] { -1, 3, 3 }, result);
    }

    @Test
    void testSingleElement() {
        int[] arr = new int[] { 10 };
        int[] result = KadaneOptimized.maxSubArray(arr);
        assertArrayEquals(new int[] { 10, 0, 0 }, result);
    }

    @Test
    void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> KadaneOptimized.maxSubArray(new int[] { }));
    }

    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> KadaneOptimized.maxSubArray(null));
    }
}
