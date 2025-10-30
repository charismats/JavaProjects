/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rekursif.src;

/**
 *
 * @author Administrator
 */
public class FindMaxRecursive {
    static int maxArray(int[] array){
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            if( max < j)
                max = j;
        }
        return max;
    }
    static int maxArrayRec(int []arr, int index){
        if( index < 0)
            return 0;
        int maxLeft = maxArrayRec(arr, index-1);
        if( maxLeft > arr[index])
            return maxLeft;
        return arr[index];
    }
    public static void main(String[] args) {
        int[] array = {2,3,1,5,4,7,6,9,8};
        int maxArr = maxArrayRec(array, array.length-1);
        System.out.println("max array : "+maxArr);
    }
}
