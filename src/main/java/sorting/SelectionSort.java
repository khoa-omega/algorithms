package sorting;

import org.jetbrains.annotations.NotNull;

public class SelectionSort extends AbstractSortingAlgorithm {
    @Override
    public void sort(final int @NotNull [] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int k = i;
            for (int j = 0; j < i; j++) {
                if (a[k] < a[j]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(a, i, k);
            }
        }
    }
}
