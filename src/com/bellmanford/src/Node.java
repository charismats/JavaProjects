/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bellmanford.src;



/**
 *
 * @author Administrator
 */
public class Node implements Comparable<Node> {
    public int id;
    public int dist;
    public Node parent;
    public Node(int i){
        id = i;
        dist = Integer.MAX_VALUE;
        parent = null;
    }

    @Override
    public int compareTo(Node o) {
        if( dist < o.dist)
            return -1;
        if ( dist > o.dist)
            return 1;
        return 0;
    }
    
}
