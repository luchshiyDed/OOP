package my.pack;

import java.util.Scanner;
import java.io.*;

public class HEAP {
    /**
     * sorts an array
     * @param arr - array that will be sorted
     */
    public void heap_sort(int[] arr) {
        int ln=arr.length;
        for (int i = ln / 2 - 1; i >= 0; i--) {
            do_a_heap(arr, ln, i);
        }

        for (int i = ln - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;

            do_a_heap(arr, i, 0);
        }
    }

    /**
     * percives an array like a tree. Recursevily converts depending on the rule that each parent>children.
     * @param arr - array
     * @param ln - the last element of the array we are looking at
     * @param i - the first element of the array we are looking at with ln describes a subtree.
     */
    void do_a_heap(int[] arr, int ln, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (right < ln && arr[right] > arr[largest])
            largest = right;
        if (left < ln && arr[left] > arr[largest])
            largest = left;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            do_a_heap(arr, ln, largest);
        }
    }
}