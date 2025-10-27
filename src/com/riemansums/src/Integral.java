/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riemansums.src;

/**
 *
 * @author Administrator
 */
public class Integral {
    static double fx(double x){
        return x*x;
    }
    static double integral(int bb, int ba){
        double deltax = (ba-bb)/100000.0f;
        double sum = 0;
        for(double i = bb ; i <= ba; i+= deltax){
            sum += fx(i) * deltax;
        }
        return sum;
    }
    public static void main(String[] args) {
        double hasil = integral(1,4);
        System.out.println("Hasil integral : "+hasil);
    }
}
