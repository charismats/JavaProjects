/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.day03.src;

/**
 *
 * @author Charisma
 */
public class DLinkedList {

    public DNode head, tail;
    public int numItems;

    public DLinkedList() {
        head = tail = null;
        numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int size() {
        return numItems;
    }

    public void insertBack(int item) {
        DNode newNode = new DNode(item);
        if (isEmpty()) {
            head = tail = newNode;
            numItems++;
            return;
        } else {
            newNode.prev = tail; //udah bener
            tail.next = newNode;
            tail = newNode;
            numItems++;
            return;
        }
    }

    public void insertFront(int item) {
        DNode newNode = new DNode(item);
        if (isEmpty()) {
            head = tail = newNode;
            numItems++;
            return;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            numItems++;
            return;
        }
    }

    public int removeFront() {
        DNode removed = null;
        if (numItems == 1) {
            removed = head;
            head = tail = null;
            numItems--;

        } else {
            removed = head;
            head = head.next;
            head.prev = null;
            removed.next = null;
            numItems--;
        }
        return removed.item;
    }

    public int removeBack() {
        DNode removed = null;
        if (numItems == 1) {
            removed = tail;
            head = tail = null;
            numItems--;
        } else {
            removed = tail;
            tail = tail.prev;
            removed.prev = null;
            tail.next = null;
            numItems--;
        }
        return removed.item;
    }

    public void printListFromFront() {
        if (isEmpty()) {
            System.out.println("DList is empty");
            return;
        }
        System.out.println("List from front:");
        DNode curr = head;
        while (curr != null) {
            System.out.println("Item : " + curr.item);
            curr = curr.next;
        }
    }

    public void printListFromBack() {
        if (isEmpty()) {
            System.out.println("DList is empty");
            return;
        }
        System.out.println("List from back: ");
        DNode curr = tail;
        while (curr != null) {
            System.out.println("Item : " + curr.item);
            curr = curr.prev;
        }
    }

    public void clearList() {
        if (isEmpty()) {
            System.out.println("List is already empty");
            return;
        } else {
            while ( size() > 0) {
                int removed = removeBack();
                //System.out.println("Removed item : " + removed);
            }
            System.out.println("List is cleared");
        }
    }

    public static void main(String[] args) {
        DLinkedList dlist = new DLinkedList();
        for (int i = 1; i <= 5; i++) {
            dlist.insertFront(i);
        }
        dlist.printListFromFront();
        dlist.printListFromBack();
        while (dlist.size() > 0) {
            int removed = dlist.removeBack();
            System.out.println("Removed item : " + removed);
        }
    }
}
