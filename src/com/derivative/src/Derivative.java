/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.derivative.src;

/**
 *
 * @author Administrator
 */
public class Derivative {
    static double fx(double x){
        return x*x;
    }
    static double derivative(double x){
        double h = 0.00001;
        return (fx(x+h)-fx(x-h))/(2*h);
    }
    public static void main(String[] args) {
        double hasil = derivative(3);
        System.out.println("Hasil derivative : "+hasil);
    }
}
