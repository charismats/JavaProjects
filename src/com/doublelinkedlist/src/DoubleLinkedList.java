package com.doublelinkedlist.src;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chari
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.global.utils.DListNode;

/**
 *
 * @author chari
 */
public class DoubleLinkedList {

    public DListNode head, tail;
    public int numItems;

    public DoubleLinkedList() {
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
        DListNode newNode = new DListNode(data);
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

    public void insertBack(int data) {
        DListNode newNode = new DListNode(data);
        if (isEmpty()) {
            head = tail = newNode;
            numItems++;
            return;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            numItems++;
            return;
        }
    }

    public int removeFront() {
        if (isEmpty()) {
            System.out.println("List already empty");
            return -1;
        }
        DListNode removed = head;
        if (size() == 1) {
            head = tail = null;
            numItems--;

        } else {
            head = head.next;
            head.prev = null;
            numItems--;
        }

        return removed.data;
    }

    public int removeBack() {
        if (isEmpty()) {
            System.out.println("List already empty");
            return -1;
        }

        DListNode removed = tail;
        if (size() == 1) {
            head = tail = null;
            numItems--;
        } else {
            tail = tail.prev;
            tail.next = null;
           
            numItems--;
        }
        return removed.data;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("Double List is empty");
            return;
        } else {
            System.out.println("Double List contents are: ");
            DListNode curr = head;
            while (curr != null) {
                System.out.println("Data : " + curr.data);
                curr = curr.next;
            }
        }
    }
}
