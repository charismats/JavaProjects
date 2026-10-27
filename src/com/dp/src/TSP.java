/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.src;

import java.util.Arrays;

/**
 *
 * @author PC
 */
public class TSP {

    private int[][] graph = {
        {0, 4, 7, 3, 6},
        {4, 0, 5, 8, 2},
        {7, 5, 0, 4, 3},
        {3, 8, 4, 0, 6},
        {6, 2, 3, 6, 0}
    };
    int N = 5;
    int VISITED_ALL = (1 << N) - 1;
    private int[][] DP;
    public String path = "";
    public TSP() {
        DP = new int[(1 << N)][N];
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(DP[i], -1);
        }
        
    }

    public int doTSP(int mask, int pos) {
        if (mask == VISITED_ALL) {
            return graph[pos][0];
        }

        if (DP[mask][pos] != -1) {
            return DP[mask][pos];
        }
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < N; city++) {
            if (graph[pos][city] > 0 && ((mask & (1 << city)) == 0)) {
                int costPath = graph[pos][city] + doTSP(mask | (1 << city), city);
                //path += city+"-";
                ans = Math.min(costPath, ans);
            }
        }
        return (DP[mask][pos] = ans);
    }

    public static void main(String[] args) {
        TSP tsp = new TSP();
        int solution = tsp.doTSP(1, 0);
        System.out.println("Total cost TSP(Dynamic Programming) : "+solution);
    }
}
