package ArraysOp;

public class ArraysOperation {

    // Merges two subarrays of array[].
    // First subarray is array[start..mid]
    // Second subarray is array[mid+1..end]
    private void merge(int array[], int start, int mid, int end) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - start + 1;
        int n2 = end - mid;

        /* Create temp arrays */
        int left[] = new int[n1];
        int right[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            left[i] = array[start + i];

        for (int j = 0; j < n2; ++j)
            right[j] = array[mid + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left[] if any */
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of right[] if any */
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    // Main function that sorts array[start..end]
    public void mergeSort(int array[], int start, int end) {
        if (start < end) {
            // Find the middle point
            int mid = (start + end) / 2;

            // Sort first and second halves
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            // Merge the sorted halves
            merge(array, start, mid, end);
        }
    }

    // Reverse an array
    public void reverseArray(Object array[]){
        for(int i = 0; i < array.length / 2; i++)
        {
            Object temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
