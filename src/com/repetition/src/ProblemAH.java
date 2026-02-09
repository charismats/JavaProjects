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
public class ProblemAH {
    
    static long countDigits(long n ){
        long digit = 0;
        while ( n > 0){
            digit++;
            n /= 10;
        }
        return digit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N ; i++){
            long X = sc.nextLong();
            long digit = countDigits(X);
            
            System.out.println("Case #"+(i+1) + " : " + digit);
                    
        }
    }
}
