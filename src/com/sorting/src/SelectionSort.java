/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sorting.src;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class SelectionSort {

    static void printArray(int[] arr) {
        System.out.println("Array Contents:");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexMin = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    indexMin = j;
                    min = arr[j];
                }
            }
            if (indexMin != i) {
                int temp = arr[i];
                arr[i] = min;
                arr[indexMin] = temp;
            }
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
        selectionSort(arr);
        //Arrays.sort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}
