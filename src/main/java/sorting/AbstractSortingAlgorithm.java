package sorting;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractSortingAlgorithm implements SortingAlgorithm {
    protected void swap(final int @NotNull [] a, final int i, final int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
