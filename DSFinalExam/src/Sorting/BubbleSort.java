package Sorting;

public class BubbleSort {


    public static void bubbleSortBest(int[] arr) {

        int n = arr.length - 1;


        for (int i = 0; i < n - 1; i++) {
            boolean swaped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }

    }

    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[i + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
