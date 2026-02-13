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
public class ProblemAK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] steps = new int[N];
        for(int i = 0; i < N ; i++){
            steps[i] = sc.nextInt();
        }
        for(int i = 0; i < steps.length; i++){
            if( i < steps.length -1 && steps[i] >= steps[i+1]){
                System.out.print( steps[i]+ " ");
            }else if ( i == steps.length - 1){
                System.out.println(steps[i]);
            }
        }
    }
}
