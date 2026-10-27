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
public class TSPKruskal {

    public int V;
    public int[][] graph = {
        {0, 4, 7, 3, 6},
        {4, 0, 5, 8, 2},
        {7, 5, 0, 4, 3},
        {3, 8, 4, 0, 6},
        {6, 2, 3, 6, 0}
    };

    public ArrayList<Edge> MSTEdges;
    public ArrayList<Edge> listEdges;
    public DisjointSets ds;

    boolean[] visited;
    int totalCost = 0;
    String path = "";

    public TSPKruskal() {
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

    public void tspMST(int start) {
        runAlgorithm();
        visited = new boolean[graph.length];

        buildPathFromMST(start, visited, 0);
        int lastCity = Integer.parseInt(path.charAt(path.length() - 2) + "");
        path += (start + 1);
        //System.out.println("Total cost : " + totalCost);
        totalCost += graph[lastCity - 1][start];
        System.out.println("TSP Path : " + path + " Total cost : " + totalCost);
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

    private void buildPathFromMST(int curr, boolean[] visited, int weight) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        totalCost += weight;
        path += (curr + 1) + "-";

        //System.out.println("Total cost : "+totalCost);
        //System.out.println("MST Edge size : "+MSTEdges.size());
        for (Edge e : MSTEdges) {
            if (e.v1 == curr) {
                System.out.println("Edge : "+e);
                buildPathFromMST(e.v2, visited, graph[e.v1][e.v2]);
            } else if (e.v2 == curr) {
                System.out.println("Edge : "+e);
                buildPathFromMST(e.v1, visited, graph[e.v2][e.v1]);
            }
        }
    }

    public static void main(String[] args) {
        TSPKruskal krus = new TSPKruskal();
        krus.tspMST(0);
    }
}
