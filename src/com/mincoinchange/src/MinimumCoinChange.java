/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mincoinchange.src;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class MinimumCoinChange {
    int[] coins = {1,3,4,5,7};
    public int doDP(int N){
        int[] Table = new int[N+1];
        Arrays.fill(Table, Integer.MAX_VALUE);
        Table[0] = 0;
        for(int i = 1; i < Table.length; i++){
            for(int j = 0; j < coins.length; j++){
                if( coins[j] <= i && Table[i - coins[j]] + 1 < Table[i]){
                    Table[i] = Table[i-coins[j]] + 1;
                }
            }
        }
        return Table[N];
    }
    public static void main(String[] args) {
        MinimumCoinChange mc = new MinimumCoinChange();
        int minCoins = mc.doDP(10);
        System.out.println("Minimum Coin for 10 = "+minCoins);
    }
}
