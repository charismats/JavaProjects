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
public class Queue extends LinkedList{
     public void enqueue(int data){
        this.insertBack(data);
    }
    
    public int dequeue(){
        return this.removeFront();
    }
    
    public void printQueue(){
        this.printList();
    }
}
