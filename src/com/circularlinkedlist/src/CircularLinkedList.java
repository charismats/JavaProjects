/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circularlinkedlist.src;

import com.global.utils.ListNode;

/**
 *
 * @author chari
 */
public class CircularLinkedList {

    public ListNode head, tail;
    public int numItems;

    public CircularLinkedList() {
        head = tail = null;
        numItems = 0;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void insertFront(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next = head;
            numItems++;
            return;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
            numItems++;
            return;
        }
    }

    public void insertBack(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next = head;
            numItems++;
            return;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            numItems++;
            return;
        }
    }
    
    
    public int removeFront(){
        if( isEmpty()){
            System.out.println("List is already empty");
            return -1;
        }
        
        ListNode removed = head;
        if( size() == 1){
            head = tail = null;
            numItems--;
            return removed.data;
        }
        else{
            head = head.next;
            tail.next = head;
            numItems--;
            return removed.data;
        }
        
    }
    
    public int removeBack(){
        if( isEmpty()){
            System.out.println("List is already empty");
            return -1;
        }
        
        ListNode removed = tail;
        if( size() == 1){
            head = tail = null;
            numItems--;
            return removed.data;
        }
        else{
            ListNode curr = head;
            while ( curr.next != tail){
                curr = curr.next;
            }
            tail = curr;
            tail.next = head;
            numItems--;
            return removed.data;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        } else {
            ListNode curr = head;
            for (int i = 0; i < size(); i++) {
                System.out.println("Data : " + curr.data);
                curr = curr.next;
            }
        }
    }

}
