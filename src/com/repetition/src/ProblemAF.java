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
public class ProblemAF {
    
    static boolean checkBits(int n){
        int bit1 = 0;
        while( n > 0){
            if( n % 2 == 1){
                bit1++;
            }
            n >>= 1;
        }
        return bit1 >= 3;
    }
    static int[] processXor(int [] arr){
        int pairon3 = 0;
        int pairnot3 = 0;
        for(int i = 0 ; i < arr.length; i++){
            int x = arr[i];
            for(int j = i+1; j < arr.length; j++){
                int y = arr[j];
                int hasil = x ^ y;
                boolean on3 = checkBits(hasil);
              
                if ( on3){
                    pairon3++;
                }else{
                    pairnot3++;
                }
            }
        }
        return new int[] {pairon3, pairnot3};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int [] arr = new int[N];
            for(int j = 0; j < N ; j++){
                arr[j] = sc.nextInt();
            }
            int [] result = processXor(arr);
            System.out.println("Case #"+(i+1) + ":" + result[0] + " " + result[1]);
        }
    }
}
