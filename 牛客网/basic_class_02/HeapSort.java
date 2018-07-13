package com.basic_class_02;

/**
 * @author Even
 * @date 2018-07-09 16:11
 * Description : 数组实现堆结构的过程，复杂度O(N)
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //实现堆结构
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //排序，因为大根堆堆顶总是最大值，所以每次取出堆顶并把堆长度-1（swap(arr, 0, --size);），重新调整为大根堆（heapify），最后得到的数组就有序的
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //和父节点比较并调整
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //数组中某个数变小后，重新调整为大根堆的过程
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //for testa
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 0};

        heapSort(arr);

        for (int b : arr) {
            System.out.print(b + " ");
        }
    }
}

