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
public class ProblemAG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T ; i++){
            int N = sc.nextInt();
            int beda = 1;
            int x = 1;
            System.out.print("Case "+(i+1)+": ");
            for(int j = 0; j < N; j++){
                System.out.print(x+" ");
                x+= beda++;
            }
            System.out.println("");
        }
    }
}
