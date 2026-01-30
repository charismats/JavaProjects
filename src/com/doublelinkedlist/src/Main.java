/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doublelinkedlist.src;

/**
 *
 * @author chari
 */
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dlist = new DoubleLinkedList();
        for(int i = 1; i <= 5; i++){
            dlist.insertBack(i);
            
        }
        dlist.printList();
        
        for(int i = 0; i < 5; i++){
            int removed = dlist.removeBack();
            System.out.println("Data removed : "+removed);
        }
    }
}
