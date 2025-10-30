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
public class BubbleSort {

    static void printArray(int[] arr) {
        System.out.println("Array Contents:");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        Random rnd = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(10);
        }
//        int[] arr = {7, 2, 1, 3, 5, 4};
        System.out.println("Array before sorting: ");
        printArray(arr);
        bubbleSort(arr);
        //Arrays.sort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}
