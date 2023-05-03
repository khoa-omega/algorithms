package sorting;

import org.jetbrains.annotations.NotNull;

public class RadixSort extends AbstractSortingAlgorithm {
    private static final int RADIX = 10;

    @Override
    public void sort(final int @NotNull [] a) {
        int max = max(a);
        for (int exp = 1; exp <= max; exp *= 10) {
            countingSort(a, exp);
        }
    }

    private void countingSort(final int @NotNull [] a, int exp) {
        int[] count = new int[RADIX];
        int[] output = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ++count[(a[i] / exp) % RADIX];
        }
        for (int i = 1; i < RADIX; i++) {
            count[i] += count[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int digit = (a[i] / exp) % RADIX;
            output[--count[digit]] = a[i];
        }
        System.arraycopy(output, 0, a, 0, a.length);
    }

    private int max(final int @NotNull [] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }
}
