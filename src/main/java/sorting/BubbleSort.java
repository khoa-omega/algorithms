package sorting;

import org.jetbrains.annotations.NotNull;

public class BubbleSort extends AbstractSortingAlgorithm {
    @Override
    public void sort(final int @NotNull [] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
}
