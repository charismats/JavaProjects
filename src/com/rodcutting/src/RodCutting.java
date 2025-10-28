/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodcutting.src;

/**
 *
 * @author Administrator
 */
public class RodCutting {
    int[] length = {1,2,3,4};
    int[] value = {1,5,8,9};
    
    public int doDP(int N){
        int [][]Table = new int[length.length + 1][N+1];
        for(int i = 0; i <= length.length ; i++){
            for(int j = 0; j <= N; j++){
                if( i == 0 || j == 0)
                    Table[i][j] = 0;
                else if ( j >= i){
                    Table[i][j] = Math.max(Table[i][j-i]+value[i-1], Table[i-1][j]);
                }else{
                    Table[i][j] = Table[i-1][j];
                }
                    
            }
        }
        return Table[length.length][N];
    }
    
    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int hasil = rc.doDP(5);
        System.out.println("Hasil DP : "+hasil);
    }
}
