package tests;

import my.pack.HEAP;

import java.io.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertArrayEquals;

public class tests {

    @Test
    public void test_two_switched_elements() {
        int[] arrin = {1, 2, 3, 4, 6, 5};
        int[] arrout = {1, 2, 3, 4, 5, 6};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }

    @Test
    public void test_haotic_element_order() {
        int[] arrin = {4, 2, 3, 1, 6, 5};
        int[] arrout = {1, 2, 3, 4, 5, 6};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }

    @Test
    public void test_same_elements() {
        int[] arrin = {6, 6, 6, 6, 6, 5};
        int[] arrout = {5, 6, 6, 6, 6, 6};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }

    @Test
    public void test_back_order() {
        int[] arrin = {6, 5, 4, 3, 2, 1};
        int[] arrout = {1, 2, 3, 4, 5, 6};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }
    @Test
    public void test_less_zero_elements() {
        int[] arrin = {5, -6, 4, 3, 2, 1};
        int[] arrout = {-6,1, 2, 3, 4, 5};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }
    @Test
    public void test_empty_massive() {
        int[] arrin = {};
        int[] arrout = {};
        HEAP main = new HEAP();
        main.heap_sort(arrin);
        assertArrayEquals(arrin, arrout);
    }
}

