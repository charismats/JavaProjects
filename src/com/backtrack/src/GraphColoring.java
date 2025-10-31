/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backtrack.src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class GraphColoring {

    int[][] graph = {
        {0, 1, 1, 0, 0},
        {1, 0, 0, 1, 0},
        {1, 0, 0, 0, 1},
        {0, 1, 0, 0, 1},
        {0, 0, 1, 1, 0}
    };
//    int[][]graph = {
//        {0,1,1},
//        {1,0,1},
//        {1,1,0},
//    };
//    int[][] graph =  {
//        {0,1,1,0},
//        {1,0,0,1},
//        {1,0,0,1},
//        {0,1,1,0},
//    };
    char[] color = {'R','G', 'B'};
    char[] graph_color;

    public GraphColoring() {
        graph_color = new char[graph.length];
        Arrays.fill(graph_color, 'W');
    }

    public void runAlgorithm() {
        //start 0
        int index = 0;
        for (int i = 0; i < color.length; i++) {
            graph_color[index] = color[i];
            recursive(index + 1);
            graph_color[index] = 'W';
        }
    }

    public void recursive(int index) {
        if (index >= graph_color.length) {
            printGraphColor();
            return;
        }
        ArrayList<Character> soln = generatePossibleSolutions(index);
        for (char c : soln) {
            graph_color[index] = c;
            recursive(index + 1);
            graph_color[index] = 'W';
        }
    }

    private ArrayList<Character> generatePossibleSolutions(int index) {
        ArrayList<Character> result = new ArrayList<>();
        try {
            if (index >= graph_color.length) {
                return result;
            }
            for (int i = 0; i < color.length; i++) {
                char c = color[i];
                boolean adaYangSama = false;
                for (int j = 0; j < graph.length; j++) {
                    if (graph[index][j] > 0 && graph_color[j] == c) {
                        adaYangSama = true;
                        break;
                    }
                }
                if (!adaYangSama) {
                    result.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("index = " + index);
        }

        return result;
    }

    private void printGraphColor() {
        System.out.println("Assignment color: ");

        for (char c : graph_color) {
            System.out.print(c + " ");

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        GraphColoring gc = new GraphColoring();
        gc.runAlgorithm();
    }

}
