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
public class Kruskal {

    public int V;
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
    public ArrayList<Edge> listEdges;
    public DisjointSets ds;

    public Kruskal() {
        V = graph.length;
        MSTEdges = new ArrayList<>();
        listEdges = new ArrayList<>();
        ds = new DisjointSets();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] > 0) {
                    Edge e = new Edge(i, j, graph[i][j]);
                    listEdges.add(e);
                }
            }
            ds.create_set(i);
        }
    }

    public void runAlgorithm() {
        Collections.sort(listEdges);

        while (MSTEdges.size() < V - 1) {
            Edge e = listEdges.removeFirst();

            int u = e.v1;
            int v = e.v2;
            if (ds.find_set(u) != ds.find_set(v)) {
                ds.union(u, v);
                MSTEdges.add(e);
            }
        }
        System.out.println("Kruskal Finished.");
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
    
    public static void main(String[] args) {
        Kruskal krus = new Kruskal();
        krus.runAlgorithm();
    }
}
