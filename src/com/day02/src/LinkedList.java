/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.day02.src;

/**
 *
 * @author Charisma
 */
public class LinkedList {
    public Node head, tail;
    public int size;
    
    public LinkedList(){
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int count(){
        return size;
    }
    
    public void insertFront(int item){
       Node newNode = new Node(item);
       if( isEmpty()){
           head = tail = newNode;
           size++;
           return;
       }
       else{
           newNode.next = head;
           head = newNode;
           size++;
       }
    }
    
    public void insertBack(int item){
        Node newNode = new Node(item);
        if( isEmpty()){
            head = tail = newNode;
            size++;
            return;
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
    }
    
    public int removeFront(){
        Node removed = null;
        if( size == 1){
            removed = head;
            head = tail = null;
            size--;
            
        }
        else{
            removed = head;
            head = head.next;
            size--;
        }
        return removed.item;
    }
    
    public int removeBack(){
        Node removed = null;
        if ( size == 1){
            removed = tail;
            head = tail = null;
            size--;
        }else{
            Node curr = head;
            while( curr.next != tail){
                curr = curr.next;
            }
            removed = tail;   
            tail = curr;
            tail.next = null;
            size--;
        }
        return removed.item;
    }
    
    public Node find(int index){
        if( index >= 1 && index <= size){
            if( index == 1)
                return head; //return by reference
            else if ( index == size){
                return tail; //return by reference
            }else{
                Node curr = head;
                for( int i = 1; i < index; i++){
                    curr = curr.next;
                }
                return curr;//return by reference
            }
        }else{
            System.out.println("Out of index");
        }
        return null;
    }
    
    public void insert(int item, int at){
        if( at >= 1 && at <= size){
            Node before = find(at-1);
            Node after = find(at);
            Node newNode = new Node(item);
            before.next = newNode;
            newNode.next = after;
            size++;
            return;  
        }
    }
    
    public void printList(){
        if( isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while(curr != null){
            System.out.println("Item : "+curr.item);
            curr = curr.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 1; i <= 5 ;i++){
            list.insertBack(i);
        }
        
        list.printList();
//        while(list.count() > 0){
//            int itemRemoved = list.removeBack();
//            System.out.println("Removed: "+itemRemoved);
//        }
        Node n1 = list.find(3);
        System.out.println("item ketiga : "+n1.item);
        list.printList();
        list.insert(100, 3);
        list.printList();
    }
}
