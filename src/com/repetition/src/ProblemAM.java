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
public class ProblemAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T ; i++){
            int N = sc.nextInt();
            for(int j = 1; j <= N; j++){
                System.out.print(j + " ");
                if( j % 15 == 0)
                    System.out.println("Lili");
                else if ( j % 3 == 0 || j % 5 == 0 )
                    System.out.println("Jojo");
                else
                    System.out.println("Lili");
                    
            }
        }
    }
}
