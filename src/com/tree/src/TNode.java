/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tree.src;

/**
 *
 * @author chari
 */
public class TNode {
    public int data;
    public TNode left, right;
    
    public TNode(int data){
        this.data = data;
        left = right = null;
    }
}
