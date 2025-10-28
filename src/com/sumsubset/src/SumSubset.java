/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sumsubset.src;

/**
 *
 * @author Administrator
 */
public class SumSubset {
    int [] v = {3,34,4,12,5,2};
    
    public boolean doDP(int N){
        boolean [][] Table = new boolean[v.length+1][N+1];
        for(int i = 0; i <= v.length; i++){
            for(int j = 0; j <= N; j++){
                if( i == 0 && j == 0){
                    Table[i][j] = true;
                }else if ( i == 0){
                    Table[i][j] = false;
                }else if ( j == 0){
                    Table[i][j] = true;
                }else if ( j >= v[i-1]){
                    Table[i][j] = Table[i-1][j] || Table[i-1][j-v[i-1]];
                }else{
                    Table[i][j] = Table[i-1][j];
                }
                //System.out.print(Table[i][j]+" ");
            }
            //System.out.println("");
        }
        
        return Table[v.length][N];
    }
    
    public static void main(String[] args) {
        SumSubset ss = new SumSubset();
        boolean exist = ss.doDP(9);
        System.out.println("Exist subset sum  :"+exist);
    }
}
