/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backtracking.src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Charisma
 */
public class PuzzlePanel extends JPanel implements KeyListener {

    Puzzle pz;
    int WIDTH = 900;
    int HEIGHT = 900;
    int grid = WIDTH / 9;
    boolean solutionFound = false;

    public PuzzlePanel() {
        pz = new Puzzle();
        setPreferredSize(new Dimension(1000, 1000));
        addKeyListener(this);
        setFocusable(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Font f = new Font("Sans Serif", Font.BOLD, 20);

        g2d.setFont(f);
        for (int i = 0; i < pz.board.length; i++) {
            for (int j = 0; j < pz.board[i].length; j++) {
                if (pz.emptyCells[i][j]) {
                    g2d.setColor((Color.RED));
                } else {
                    g2d.setColor(Color.BLUE);
                }
                if (pz.board[i][j] != 0) {
                    g2d.drawString(pz.board[i][j] + "", grid * j + 50, grid * i + 50);
                }

            }
        }

        g2d.setColor(Color.BLACK);
        float lineWidth = 1.0f;
        for (int i = 0; i <= pz.board.length; i++) {
            if (i % 3 == 0) {
                lineWidth = 5.0f;

            } else {
                lineWidth = 1.0f;
            }
            g2d.setStroke(new BasicStroke(lineWidth));
            g2d.drawLine(0, grid * i, WIDTH, grid * i);
        }
        for (int i = 0; i <= pz.board.length; i++) {
            if (i % 3 == 0) {
                lineWidth = 5.0f;

            } else {
                lineWidth = 1.0f;
            }
            g2d.setStroke(new BasicStroke(lineWidth));
            g2d.drawLine(grid * i, 0, grid * i, HEIGHT);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                solutionFound = pz.solve(0);
                break;
        }
        repaint();
    }

}
