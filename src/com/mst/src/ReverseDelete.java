/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mst.src;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Administrator
 */
public class ReverseDelete {

    public int[][] graph = {
        {0, 7, 0, 5, 0, 0, 0},
        {7, 0, 8, 9, 7, 0, 0},
        {0, 8, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9},
        {0, 0, 0, 6, 8, 0, 11},
        {0, 0, 0, 0, 9, 11, 0}
    };

    public ArrayList<Edge> MSTEdges;
    
    public void runAlgorithm() {
        MSTEdges = new ArrayList<>();
       
        //initialize listEdges MST Edges
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[0].length; j++) {
                if (graph[i][j] != 0) {
                    Edge e = new Edge(i, j, graph[i][j]);
                    MSTEdges.add(e);
                }
            }
        }

        int edgeCount = 0;
        Collections.sort(MSTEdges, Collections.reverseOrder());
        while (edgeCount < MSTEdges.size()) {
            Edge current = MSTEdges.removeFirst();

            if (isDisconnected(current)) {
                MSTEdges.add(current);
                edgeCount++;
            }
        }
        System.out.println("Reverse Delete Finished.");
        printMST();
    }

    private void printMST() {
        System.out.println("MST contains vertices : ");
        for (int vertice = 0; vertice < graph.length; vertice++) {
            char v = (char) (vertice + 'A');
            System.out.println("Vertice : " + v);
        }
        System.out.println("List of edges in MST : ");
        for (int i = 0; i < MSTEdges.size(); i++) {
            Edge e = MSTEdges.get(i);
            char V1 = (char) (e.v1 + 'A');
            char V2 = (char) (e.v2 + 'A');
            System.out.println(V1 + " -> " + V2 + " = " + e.w);
        }
    }

    private boolean isDisconnected(Edge e) {
        boolean[] visited = new boolean[graph.length];
        int start = e.v1;
        DFS(start, visited);
        int countVisited = 0;
        for (boolean v : visited) {
            if (v) {
                countVisited++;
            }
        }
        return countVisited != graph.length;
    }

    private void DFS(int curr, boolean[] visited) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (Edge e : MSTEdges) {
            if (e.v1 == curr) {
                DFS(e.v2, visited);
            }
            if (e.v2 == curr) {
                DFS(e.v1, visited);
            }
        }
    }

    public static void main(String[] args) {
        ReverseDelete rd = new ReverseDelete();
        rd.runAlgorithm();
    }
}
