package com;

/**
 * 逆序对问题，采用归并排序，降序排列
 */

public class InversePairs {

    public static int inversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int j = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] > arr[p2]) {
                res += (r - p2 + 1);
                help[j++] = arr[p1];
                for (int i = p2; i <= r; i++) {
                    System.out.print("（" + arr[p1] + "," + arr[i] + ")" + " ");
                }
                ++p1;
            } else {
                help[j++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[j++] = arr[p1++];
        }
        while (p2 <= r) {
            help[j++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    //for testa
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 0};

        int a = InversePairs.inversePairs(arr);
        System.out.println("共" + a + "对");

        for (int b : arr) {
            System.out.print(b + " ");
        }
    }
}
