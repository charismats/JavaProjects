/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tree.src;

/**
 *
 * @author chari
 */
public class Main {
    public static void main(String[] args) {
        BST t = new BST();
        t.insert(10);
        t.insert(2);
        t.insert(8);
        t.insert(3);
        t.insert(12);
        t.insert(20);
        t.insert(21);
        t.InOrderTraverse();
        t.PreOrderTraverse();
        t.PostOrderTraverse();
    }
}
