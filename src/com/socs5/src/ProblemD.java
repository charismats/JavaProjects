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
public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long total = 0;
        long bonus = 0;
        for(int i = 0; i < N ; i++){
            total += 100 + bonus;
            bonus += 50;
        }
        System.out.println(total);
    }
}
