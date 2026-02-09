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
public class ProblemAE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int i = 0; i < T ; i++){
            int R = sc.nextInt();
            int H = sc.nextInt();
            double area = 2*3.14*R*R + 2*3.14*R*H;
            System.out.println("Case #"+(i+1)+ " : "+area);
        }
        
    }
}
