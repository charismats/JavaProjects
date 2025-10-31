/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bellmanford.src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class BellmanFord {
    
    final int FAR = Integer.MIN_VALUE;
    int[][] graph = {
        {0,5,FAR,FAR,FAR},
        {FAR,0,1,2,FAR},
        {FAR,FAR,0,FAR,1},
        {FAR,FAR,FAR,0,FAR},
        {FAR,FAR,FAR,-1,0},
    };
    ArrayList<Edge> listEdges;
    int[] dist;
    Node[] nodes;
    
    public BellmanFord(){
        listEdges = new ArrayList<>();
        dist = new int [graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        nodes = new Node[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if( i != j && graph[i][j] > FAR){
                    Edge e= new Edge(i,j,graph[i][j]);
                    listEdges.add(e);
                    //System.out.println(e);
                }
            }
            Node n = new Node(i);
            nodes[i] = n;
        }
       
    }
    public void runAlgorithm(){
        dist[0] = 0;
        boolean findSolution = true;
        for(int i = 0; i < graph.length;i++){
            
            for(Edge e : listEdges){
                int v1 = e.v1;
                int v2 = e.v2;
                int w = e.w;
                //System.out.println(e);
                if( dist[v1] != Integer.MAX_VALUE && dist[v1] + w < dist[v2]){
                    if( i == graph.length -1){
                        findSolution = false;
                    }
                    nodes[v2].parent = nodes[v1];
                    dist[v2] = dist[v1] + w;
                }
            }
            if( !findSolution)
                break;
        }
        if( findSolution){
            printShortestDistance();
        }
        else{
            System.out.println("Cannot find shortest path because negative weight cycle");
        }
    }
    private void printShortestDistance(){
        System.out.println("Shortest Distance Result: ");
        for(int i = 0; i < dist.length ;i++){
            
            System.out.println("Shortest distance from Node 0 to Node "+i+" = "+dist[i]);
            String path = getPath(nodes[0], nodes[i]);
            System.out.println("Path : "+path);
        }
    }
    
    private String getPath(Node start, Node dest){
        Node current = dest;
        String path = "";
        while ( current != start){
            path = "-" + current.id  + path;
            current = current.parent;
        }
        path = current.id + path;
        return path;
    }
    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord();
        bf.runAlgorithm();
    }
}
