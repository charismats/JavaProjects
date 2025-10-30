/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sorting.src;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class QuickSort {

    static void printArray(int[] arr) {
        System.out.println("Array Contents:");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    //O(n)
    static int partition(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int pivot = arr[mid];
        swap(arr, mid, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //O (n)
            int pivot = partition(arr, start, end);
          
            //divide O(lgn)
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
//        int[] arr = {7, 2, 1, 3, 5, 4};
        System.out.println("Array before sorting: ");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        //Arrays.sort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}
