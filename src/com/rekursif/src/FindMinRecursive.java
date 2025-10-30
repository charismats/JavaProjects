/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rekursif.src;

/**
 *
 * @author Administrator
 */
public class FindMinRecursive {
     static int minArrayRec(int []arr, int index){
        if( index < 0)
            return Integer.MAX_VALUE;
        int minLeft = minArrayRec(arr, index-1);
        if( minLeft < arr[index])
            return minLeft;
        return arr[index];
    }
    public static void main(String[] args) {
        int[] array = {2,3,1,5,4,7,6,9,8};
        int minArr = minArrayRec(array, array.length-1);
        System.out.println("min array : "+minArr);
    }
}
