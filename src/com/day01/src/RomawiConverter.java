/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.day01.src;

/**
 *
 * @author Charisma
 */
public class RomawiConverter {

    static String[] roms = {"I", "IV", "V", "IX", "X", "XL", "L"};
    static int[] values = {1, 4, 5, 9, 10,40,50};

    public static String convertToRomawi(int value) {
        String returnedRomawi = "";

        for (int i = roms.length - 1; i >= 0; i--) {
            while (value >= values[i]) {
                value -= values[i];
                returnedRomawi += roms[i];
            }
        }
        return returnedRomawi;
    }

    public static void main(String[] args) {
        int n = 75;
        String romawi = convertToRomawi(n);
        System.out.println("Romawi : "+romawi);
    }
}
