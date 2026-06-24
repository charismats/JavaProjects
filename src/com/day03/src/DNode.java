/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.day03.src;

/**
 *
 * @author Charisma
 */
public class DNode {
    public int item;
    public DNode next, prev;
    
    public DNode(int data){
        item = data;
        next = prev = null;
    }
}
