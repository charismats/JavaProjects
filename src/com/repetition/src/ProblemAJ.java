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
public class ProblemAJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long sum = 0;
        for(int i =0 ; i < N ;i++){
            sum += sc.nextInt();
        }
        
        System.out.println(sum);
    }
}
