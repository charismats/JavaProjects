/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trapezoid.src;

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
            if( i == bb || i == ba){
                sum += fx(i);
            }else {
                sum += 2*fx(i);
            }
            
        }
        return sum*deltax/2;
    }
    public static void main(String[] args) {
        double hasil = integral(1,3);
        System.out.println("Hasil integral : "+hasil);
    }
}
