/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backtracking.src;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Charisma
 */
public class PuzzleFrame extends JFrame{
    public PuzzleFrame(){
        setTitle("Sudoku Solver");
        setPreferredSize(new Dimension(1000,1000));
        setContentPane(new PuzzlePanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        PuzzleFrame pf = new PuzzleFrame();
        
    }
}
