/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circularlinkedlist.src;

/**
 *
 * @author chari
 */
public class Main {
      public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for (int i = 1; i <= 5; i++) {
            list.insertBack(i);
        }
        list.printList();

        for(int i = 0;i < 5; i++){
            int removed = list.removeBack();
            System.out.println("Data removed : "+ removed);
        }
        list.printList();
    }
}
