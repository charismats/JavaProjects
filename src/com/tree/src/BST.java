/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tree.src;

/**
 *
 * @author chari
 */
public class BST {

    public TNode root;

    public void insert(int data) {

        root = insertNode(root, data);

    }

    public TNode insertNode(TNode current, int data) {
        if (current == null) {
            current = new TNode(data);
            return current;
        }
        if (current.data >= data) {
            current.left = insertNode(current.left, data);
            //return current.left;
        } else {
            current.right = insertNode(current.right, data);
            //return current.right;
        }
        return current;
    }

    public void InOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println("In Order Traversal : ");
        inOrder(root);
    }

    private void inOrder(TNode current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.println("Data = " + current.data);
        inOrder(current.right);
    }

    public void PreOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
         System.out.println("Pre Order Traversal : ");
        preOrder(root);
    }

    private void preOrder(TNode current) {
        if (current == null) {
            return;
        }
        System.out.println("Data = " + current.data);
        preOrder(current.left);
        preOrder(current.right);
    }

    public void PostOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
         System.out.println("Post Order Traversal : ");
        postOrder(root);
    }

    private void postOrder(TNode current) {
        if (current == null) {
            return;
        }

        postOrder(current.left);
        postOrder(current.right);
        System.out.println("Data = " + current.data);
    }

}
