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
public class MergeSort {
    static void printArray(int[] arr) {
        System.out.println("Array Contents:");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    //bagian heavy (O (n))
    static void merge(int [] arr, int l, int m, int r){
        int n1 = m-l+ 1;
        int n2 = r-m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m+1+j];
        }
        int i = 0, j = 0;
        int k = l;
        
        while ( i < n1 && j < n2){
            if ( L[i] <= R[j]){
                arr[k++] = L[i++];
            }else{
                arr[k++] = R[j++];
            }
        }
        while ( i < n1){
            arr[k++] = L[i++];
        }
        while ( j < n2){
            arr[k++] = R[j++];
        }
    }
    static void mergeSort(int[] arr, int start, int end) {
        if( start < end){
            int mid = (start + end) / 2;
            //divide
            //O(lg n)
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            //O(n)
            //conquer
            merge(arr, start, mid, end);
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
        mergeSort(arr, 0 , arr.length - 1);
        //Arrays.sort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}
