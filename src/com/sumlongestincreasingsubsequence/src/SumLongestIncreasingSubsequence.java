/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sumlongestincreasingsubsequence.src;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class SumLongestIncreasingSubsequence {
    int[] arr = {3, 10, 2, 1, 20};
    
    public int doDP(){
        int[] Table = Arrays.copyOf(arr, arr.length);
        int sum = 0;
        for(int j = 1; j < arr.length; j++){
            for(int i = 0; i < j ; i++){
                if( arr[j] > arr[i] && Table[i] + arr[j] > Table[j]){
                    Table[j] = Table[i] + arr[j];
                }
            }
        }
        int maxSum = 0;
        for(int n : Table){
            //System.out.print(n + " ");
            if ( maxSum < n)
                maxSum = n;
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
       SumLongestIncreasingSubsequence sumLong = new SumLongestIncreasingSubsequence();
       int sum = sumLong.doDP();
        System.out.println("Sum Longest Increasing : "+sum);
    }
}
