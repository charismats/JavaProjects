/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mst.src;

/**
 *
 * @author Administrator
 */
public class Edge implements Comparable<Edge>{

    public int v1;
    public int v2;
    public int w;
    
    public Edge(int i, int j, int a){
        v1 = i;
        v2 = j;
        w = a;
    }
    @Override
    public int compareTo(Edge o) {
       if( w < o.w)
           return -1;
       if ( w > o.w)
           return 1;
       return 0;
    }
    
    public String toString(){
        return "("+v1+","+v2+") = "+w;
    }
    
}
