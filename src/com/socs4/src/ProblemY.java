/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socs4.src;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ProblemY {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T ; i++){
            double percent = sc.nextDouble();
            double value = sc.nextDouble();
            double res = percent * value / 100;
            System.out.println(res);
        }
    }
}
