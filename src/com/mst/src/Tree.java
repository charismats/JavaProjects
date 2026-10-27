/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mst.src;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Tree {
    private  ArrayList<Integer> components;
    public Edge minEdge;
    
    public Tree(int i){
        components = new ArrayList<>();
        components.add(i);
    }
    
    public void addComponent(int v){
        boolean exists = false;
        for(int comp : components){
            if( comp == v){
                exists = true;
                break;
            }
        }
        if( !exists){
            //System.out.println("Adding component : "+v);
            components.add(v);
        }
    }
    
    public ArrayList<Integer> getComponents(){
        return components;
    }
    
}
