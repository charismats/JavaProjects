/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dijkstra.src;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Administrator
 */
public class Dijkstra {
    int[][] graph = {
        {0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0,11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9,14, 0, 0, 0},
        {0, 0, 0, 9, 0,10, 0, 0, 0},
        {0, 0, 4,14,10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8,11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0},
    };
    
    private PriorityQueue<Node> pq;
    private boolean visited[];
    private ArrayList<Node> nodeList;
    public Dijkstra(){
        pq = new PriorityQueue<>();
        visited = new boolean[graph.length];
        nodeList = new ArrayList<>();
        
    }
    
    public void runDijkstra(){
        //initialize node list
        for(int i = 0; i < graph.length; i++){
            Node n = new Node(i);
            nodeList.add(n);
        }
        Node start = nodeList.get(0);
        start.dist = 0;
        pq.add(start);
        
        while( !pq.isEmpty()){
            Node current = pq.remove();
            int id = current.id;
            if ( visited[id])
                continue;
            visited[id] = true;
            for(int j = 0; j < graph[0].length; j++){
                Node neighbour = nodeList.get(j);
                if( graph[id][j] > 0 && neighbour.dist > current.dist + graph[id][j]){
                    neighbour.dist = current.dist + graph[id][j];
                    neighbour.parent = current;
                    pq.add(neighbour);
                }
            }
            
        }
        
        System.out.println("Dijkstra Finished");
        printShortestDistance();
        
    }
    private void printShortestDistance(){
        for(Node n : nodeList){
            System.out.println("Shortest distance from Node 0 to Node "+n.id+" = "+n.dist);
            String path = getPath(nodeList.get(0), n);
            System.out.println("Path = "+path);
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
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.runDijkstra();
    }
}
