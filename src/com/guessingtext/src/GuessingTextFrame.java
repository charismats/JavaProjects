/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessingtext.src;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Charisma
 */
public class GuessingTextFrame extends JFrame{
    public GuessingTextFrame(){
        setTitle("Guessing Text Genetic Algorithm Java");
        setPreferredSize(new Dimension(800,600));
        pack();
        setContentPane(new GuessingTextPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        GuessingTextFrame gtf = new GuessingTextFrame();
    }
}
