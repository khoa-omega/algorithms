package sorting;

import org.jetbrains.annotations.NotNull;

public class MergeSort extends AbstractSortingAlgorithm {
    @Override
    public void sort(final int @NotNull [] a) {
        int[] sorted = mergeSort(a);
        System.arraycopy(sorted, 0, a, 0, a.length);
    }

    private int[] mergeSort(final int @NotNull [] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        int[] left = mergeSort(copy(a, 0, mid));
        int[] right = mergeSort(copy(a, mid, a.length));
        return merge(left, right);
    }

    private int[] merge(final int @NotNull [] left, final int @NotNull [] right) {
        final int[] a = new int[left.length + right.length];
        int i = 0, j = 0;
        for (int k = 0; k < a.length; k++) {
            if (i == left.length) {
                a[k] = right[j++];
            } else if (j == right.length) {
                a[k] = left[i++];
            } else if (left[i] < right[j]) {
                a[k] = left[i++];
            } else {
                a[k] = right[j++];
            }
        }
        return a;
    }

    private int[] copy(final int @NotNull [] source, final int start, final int end) {
        int length = end - start;
        int[] destination = new int[length];
        System.arraycopy(source, start, destination, 0, length);
        return destination;
    }
}
