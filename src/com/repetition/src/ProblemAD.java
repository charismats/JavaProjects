/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repetition.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemAD {
    public static void main(String[] args) {
        int [] freq = new int [1001];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N ; i++){
            int num = sc.nextInt();
            freq[num]++;
        }
        int maxFreq = 0;
        for(int i = 0; i < freq.length ;i++){
            if( maxFreq < freq[i])
                maxFreq = freq[i];
        }
        System.out.println(maxFreq);
    }
}
