/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socs5.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T ; i++){
            int C = sc.nextInt();
            double R = 4.0/5 * C;
            double F = 9.0/5 * C + 32.0;
            double K = 273.0 + C;
            System.out.println(R + " " +  F + " " + K);
        }
    }
}
