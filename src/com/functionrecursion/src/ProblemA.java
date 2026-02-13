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
public class ProblemA {

    static int Ncalled = 0;
    static int NMultiple3 = 0;

    static int F(int n) {
        Ncalled++;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n % 3 == 0) {
            NMultiple3++;
        }
        if (n % 5 == 0) {
            return n * 2;
        }

        return F(n - 1) + n + F(n - 2) + n - 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            Ncalled = NMultiple3 = 0;
            int hasil = F(n);
            System.out.println("Case #" + (i + 1) + " : " + hasil + " " + NMultiple3);

        }
    }

}
