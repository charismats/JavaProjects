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
public class Prim {

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
    public ArrayList<Integer> visited_vertices;
    public PriorityQueue<Edge> pq;
    public int V;

    public Prim() {
        this.V = graph.length;
        MSTEdges = new ArrayList<>();
        listEdges = new ArrayList<>();
        visited_vertices = new ArrayList<>();
        pq = new PriorityQueue<>();
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

    public static void main(String[] args) {
        Prim prim = new Prim();
        prim.runAlgorithm();
    }
}