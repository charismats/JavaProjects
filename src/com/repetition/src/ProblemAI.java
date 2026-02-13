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
public class ProblemAI {
    
    static boolean splitSumEqual(int [] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int sumLeft= 0;
            for(int j = 0; j <= i; j++)
                sumLeft += arr[j];
            int sumRight = 0;
            for(int j = i+1; j < arr.length ; j++)
                sumRight += arr[j];
            
            if( sumLeft == sumRight )
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int j = 0; j < N ; j++){
                arr[j] = sc.nextInt();
            }
            boolean splitSumSame = splitSumEqual(arr);
            System.out.print("Case #"+(i+1) + ": ");
            if( splitSumSame)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
