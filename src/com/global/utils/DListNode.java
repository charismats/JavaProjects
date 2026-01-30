/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.global.utils;

/**
 *
 * @author chari
 */
public class DListNode {
    public int data;
    public DListNode prev;
    public DListNode next;
    
    public DListNode(int data){
        this.data = data;
        prev = next = null;
    }
}
