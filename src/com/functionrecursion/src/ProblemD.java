/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionrecursion.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemD {
    
    static int F (int n){
        if( n == 1)
            return 1;
        
        if ( n % 2 == 1){
            return F(n-1) + F(n+1);
        }
        return F(n/2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            System.out.println("Case #"+(i+1) + ":"+F(n));
        }
    }
}
