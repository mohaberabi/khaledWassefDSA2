package Sorting;

public class SelectionSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];

        arr[j] = temp;
    }

    static void selectionSortOptimal(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = 1 + i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;

                }
            }
            swap(arr, i, minIndex);
        }
    }

    static void selectionSortNaive(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];


        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            temp[i] = arr[min];
            arr[min] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

    }
}
