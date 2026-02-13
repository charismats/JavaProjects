/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionrecursion.src;

import java.util.Scanner;

/**
 *
 * @author Charisma
 */
public class ProblemB {

    static int leaveCount(int[] arr, int index, int sum) {
        if (index > arr.length - 1) {
            return 0;
        }
        sum += arr[index];
       
        int SumLeft = leaveCount(arr, 2 * index + 1, sum );
        int SumRight = leaveCount(arr, 2 * index + 2, sum);
        if( SumLeft == 0 && SumRight == 0)
            System.out.println(sum);

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println("Case #"+(i+1)+":");
            leaveCount(arr, 0, 0);
        }
    }
}
