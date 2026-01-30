/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackqueue.src;

import com.linkedlist.src.LinkedList;

/**
 *
 * @author chari
 */
public class Stack extends LinkedList{
    public void push(int data){
        this.insertFront(data);
    }
    
    public int pop(){
        return this.removeFront();
    }
    
    public void printStack(){
        this.printList();
    }
}
