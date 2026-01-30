/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.linkedlist.src;

import com.global.utils.ListNode;

/**
 *
 * @author chari
 */
public class LinkedList {

    public ListNode head, tail;
    public int numItems;

    public LinkedList() {
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
            numItems++;
            return;
        } else {
            newNode.next = head;
            head = newNode;
            numItems++;
            return;
        }
    }

    public void insertBack(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = tail = newNode;
            numItems++;
            return;
        } else {
            tail.next = newNode;
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
        ListNode removed = head;
        if (size() == 1) {
            head = tail = null;
            numItems--;

        } else {
            head = head.next;
            numItems--;
        }

        return removed.data;
    }

    public int removeBack() {
        if (isEmpty()) {
            System.out.println("List already empty");
            return -1;
        }

        ListNode removed = tail;
        if (size() == 1) {
            head = tail = null;
            numItems--;
        } else {
            ListNode curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            tail = curr;
            numItems--;
        }
        return removed.data;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        } else {
            System.out.println("List contents are: ");
            ListNode curr = head;
            while (curr != null) {
                System.out.println("Data : " + curr.data);
                curr = curr.next;
            }
        }
    }
}
