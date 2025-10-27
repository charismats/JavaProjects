/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.longestincreasingsubsequence.src;

import java.util.Arrays;

/**
 *
 * @author Charisma
 */
public class LongestIncreasingSubsequence {

    int[] arr = {3, 10, 2, 1, 20};

    public int doDP() {
        int Table[] = new int[arr.length];
        Arrays.fill(Table, 1);

        for (int j = 1; j < arr.length; j++) {
            int temp = 0;
            for (int i = 0; i < j; i++) {
                if (arr[j] > arr[i]) {
                    if (Table[i] + Table[j] > temp) {
                        temp = Table[i] + Table[j];
                    }
                }
            }
            if (temp != 0) {
                System.out.println("j = " + j + " temp = " + temp);
                Table[j] = temp;
            }
        }
        for (int n : Table) {
            System.out.print(n + " ");
        }
        return Table[arr.length - 1];
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int longest = lis.doDP();
        System.out.println("Hasil : " + longest);
    }
}
