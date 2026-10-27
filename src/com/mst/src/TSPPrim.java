/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mst.src;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Administrator
 */
public class TSPPrim {

    public int[][] graph = {
        {0, 4, 7, 3, 6},
        {4, 0, 5, 8, 2},
        {7, 5, 0, 4, 3},
        {3, 8, 4, 0, 6},
        {6, 2, 3, 6, 0}

    };

    public ArrayList<Edge> MSTEdges;
    public ArrayList<Edge> listEdges;
    public ArrayList<Integer> visited_vertices;
    public PriorityQueue<Edge> pq;
    public int V;
    boolean[] visited;
    int totalCost = 0;
    String path = "";

    public TSPPrim() {
        this.V = graph.length;
        MSTEdges = new ArrayList<>();
        listEdges = new ArrayList<>();
        visited_vertices = new ArrayList<>();
        pq = new PriorityQueue<>();
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
        int start = 0;
        visited_vertices.add(start);

        for (int j = 0; j < V; j++) {
            if (graph[start][j] > 0) {
                Edge e = new Edge(start, j, graph[start][j]);
                pq.add(e);
            }
        }

        while (visited_vertices.size() < V) {
            Edge minEdge = pq.remove();
            int u = minEdge.v1;
            int v = minEdge.v2;

            if (!visited_vertices.contains(v)) {
                MSTEdges.add(minEdge);
                visited_vertices.add(v);

                for (int j = 0; j < V; j++) {
                    if (graph[v][j] > 0 && !visited_vertices.contains(j)) {
                        Edge e = new Edge(v, j, graph[v][j]);
                        pq.add(e);
                    }
                }
            }

        }
        System.out.println("Prim Finished.");
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
        for (Edge e : MSTEdges) {
            if (e.v1 == curr) {
                buildPathFromMST(e.v2, visited, graph[e.v1][e.v2]);
            } else if (e.v2 == curr) {
                buildPathFromMST(e.v1, visited, graph[e.v2][e.v1]);
            }
        }
    }

    public static void main(String[] args) {
        TSPPrim prim = new TSPPrim();
        prim.tspMST(0);
    }
}
