/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socs6.src;

import java.util.Scanner;

/**
 *
 * @author chari
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.print("Case #"+(i+1)+ ": ");
            if( A > B){
                System.out.println("Go-Jo");
            }else{
                System.out.println("Bi-Pay");
            }
        }
    }
}
