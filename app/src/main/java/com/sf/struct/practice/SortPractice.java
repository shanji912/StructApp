package com.sf.struct.practice;

public class SortPractice {
    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] >= array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int min, temp;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void insertSort(int[] array) {
        int len = array.length;
        int current;
        for (int i = 0; i < len - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot-1);
        quickSort(array, pivot + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] > pivot) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }


        array[low] = pivot;
        return low;
    }

}
