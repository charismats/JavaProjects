/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.greedy.src;

/**
 *
 * @author Charisma
 */
public class TSPGreedy {

    int[][] graph = {
        {0, 4, 7, 3, 6},
        {4, 0, 5, 8, 2},
        {7, 5, 0, 4, 3},
        {3, 8, 4, 0, 6},
        {6, 2, 3, 6, 0}
    };
    boolean[] visited;
    int totalCost = 0;
    String path = "";

    public void tspGreedy(int start) {
        visited = new boolean[graph.length];
        totalCost = 0;
        path = "";
        tspDFS(start); 
        int lastCity = Integer.parseInt(path.charAt(path.length() - 2) + "");
        path += (start+1);
        totalCost += graph[lastCity-1][start];
        System.out.println("TSP Path : " + path + " Total cost : " + totalCost);
    }

    public void tspDFS(int current) {
        if (visited[current]) {
            return ;
        }
        visited[current] = true;
        path += (current+1) + "-";
        int costMin = Integer.MAX_VALUE;
        int neighbourMin = -1;
        for (int i = 0; i < graph[current].length; i++) {
            if (graph[current][i] != 0 && !visited[i] && graph[current][i] < costMin) {
                costMin = graph[current][i];
                neighbourMin = i;
            }
        }
        if (neighbourMin != -1) {
            //System.out.println("Neighbourmin : "+(neighbourMin+1));
            totalCost += graph[current][neighbourMin];
            tspDFS(neighbourMin);
        }
        
    }

    public static void main(String[] args) {
        TSPGreedy tsp = new TSPGreedy();
        tsp.tspGreedy(0);
    }
}
