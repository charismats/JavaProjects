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
public class ProblemC {
    
    static int A(int m, int n){
        if( m == 0)
            return n+1;
        if( n == 0)
            return A(m-1,1);
        else
            return A(m-1, A(m,n-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int hasil = A(M,N);
        System.out.println("result : "+hasil);
    }
}
