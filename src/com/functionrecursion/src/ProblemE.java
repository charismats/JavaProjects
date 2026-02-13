/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionrecursion.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemE {
    static int sum(int [] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            result += j;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int [] arr = new int[N];
            for(int j = 0; j < N ; j++){
                arr[j] = sc.nextInt();
            }
            int sumArr = sum(arr);
            System.out.println("Case #"+(i+1) + " : "+sumArr);
        }
    }
}
