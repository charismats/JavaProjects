/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stackqueue.src;

/**
 *
 * @author chari
 */
public class Main {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue q = new Queue();
        for(int i = 1; i <= 5; i++){
            st.push(i);
            q.enqueue(i);
        }
        
        st.printStack();
        q.printQueue();
        while(!st.isEmpty()){
            int removed = st.pop();
            System.out.println("Data Removed : "+removed);
        }
        
        while (!q.isEmpty()){
            int removed = q.dequeue();
            System.out.println("Data Removed : "+removed);
        }
    }
 
}
