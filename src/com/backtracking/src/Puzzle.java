/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backtracking.src;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Charisma
 */
public class Puzzle {

    public int[][] board;
    private ArrayList<Integer> listEmptyCells;
    private int idxEmpty = 0;
    public boolean[][] emptyCells;

    public Puzzle() {
        board = new int[9][9];
        emptyCells = new boolean[9][9];

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select problem: 1,2,3,4,5?");
        int opsi = sc.nextInt();
        switch (opsi) {
            case 1:
                readProblem("Grid.txt");
                break;
            case 2:
                readProblem("Grid2.txt");
                break;
            case 3:
                readProblem("Grid3.txt");
                break;
            case 4:
                readProblem("Grid4.txt");
                break;
            case 5:
                readProblem("Grid5.txt");
                break;
        }
        //readProblem("Grid.txt");
        printBoard();

    }

    private void readProblem(String path) {
        try {
            listEmptyCells = new ArrayList<>();
            Scanner sc = new Scanner(new File(path));
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] == 0) {
                        emptyCells[i][j] = true;
                        listEmptyCells.add(i * board.length + j);
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean solve(int idxEmpty) {
        if (idxEmpty > listEmptyCells.size() - 1) {
            System.out.println("Solution found");
            return true;
        }
        //printBoard();
        boolean searchFoundSolution = false;

        int idEmpty = listEmptyCells.get(idxEmpty);

        int rowEmpty = idEmpty / board.length;
        int colEmpty = idEmpty % board.length;

        int sector = rowEmpty / 3 * 3 + colEmpty / 3;
        //System.out.println("rowEmpty : " + rowEmpty + " colEmpty: " + colEmpty + " sector : " + sector);
        List<Integer> possibleSolution = findPossibleSolution(rowEmpty, colEmpty, sector);
        if (possibleSolution.size() == 0) {
            return false;
        }

        for (int value : possibleSolution) {
            board[rowEmpty][colEmpty] = value;

            searchFoundSolution = solve(++idxEmpty);
            if (!searchFoundSolution) {
                board[rowEmpty][colEmpty] = 0;
                idxEmpty--;
            } else {
                return true;
            }
        }

        return searchFoundSolution;
    }

    private List<Integer> findPossibleSolution(int rowEmpty, int colEmpty, int sector) {
        List<Integer> possibleSolutions = new ArrayList<>();

        boolean[] numExistInSector = new boolean[9];
        int startSectorRow = rowEmpty / 3;
        int startSectorCol = colEmpty / 3;
        for (int i = startSectorRow * 3; i < startSectorRow * 3 + 3; i++) {
            for (int j = startSectorCol * 3; j < startSectorCol * 3 + 3; j++) {
                if (board[i][j] != 0) {
                    numExistInSector[board[i][j] - 1] = true;
                }
            }
        }
        for (int i = 0; i < numExistInSector.length; i++) {
            if (!numExistInSector[i]) {
                possibleSolutions.add(i + 1);
            }
        }
        boolean[] numExistInRow = new boolean[9]; //check horizontal
        for (int j = 0; j < board[0].length; j++) {
            int value = board[rowEmpty][j];
            if (possibleSolutions.stream().anyMatch(n -> n == value)) {
                possibleSolutions.remove(possibleSolutions.indexOf(value));
            }
        }
        boolean[] numExistInCol = new boolean[9]; //check vertical
        for (int i = 0; i < board.length; i++) {
            int value = board[i][colEmpty];
            if (possibleSolutions.stream().anyMatch(n -> n == value)) {
                possibleSolutions.remove(possibleSolutions.indexOf(value));
            }
        }
        return possibleSolutions;
    }

    public void printBoard() {
        System.out.println("SUDOKU CONTENTS:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        boolean searchFound = puzzle.solve(0);
        if (searchFound) {
            puzzle.printBoard();
        }
    }
}
