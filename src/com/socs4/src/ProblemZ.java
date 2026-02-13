/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socs4.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemZ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T ; i++){
            float a = sc.nextInt(); float b  = sc.nextInt(); float c = sc.nextInt(); float d = sc.nextInt();
            float sum = 2 * a + 2 * b + 4/3.0f * c + 2/4.0f * d;
            
            System.out.printf("%.2f\n",sum);
        }
    }
}
