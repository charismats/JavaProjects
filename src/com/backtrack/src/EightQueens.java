/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backtrack.src;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EightQueens {

    int N = 6;
    int[][] board;

    public EightQueens() {
        board = new int[N][N];
    }

    public void runAlgorithm() {
        int col = 0;
        for (int row = 0; row < N; row++) {
            board[row][col] = 1;
            recursive(row, col+1);
            board[row][col] = 0;
        }

    }
    
    private void recursive(int row, int col){
        if( col >= N){
            System.out.println("Solution Found: ");
            printBoard();
        }
        
        ArrayList<Integer> soln = getPossibleSolution(row, col);
        for(int r : soln){
            //printPossibleSolution(soln);
            board[r][col] = 1;
            recursive(r, col+1);
            board[r][col] = 0;
        }
    }
    
    private void printPossibleSolution(ArrayList<Integer> soln){
        for(int r: soln){
            System.out.print(r +  " ");
        }
        System.out.println("");
    }
    
    private ArrayList<Integer> getPossibleSolution(int row, int col){
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            int r = i;
            boolean adaQueen = false;
            for(int c = 0; c < col; c++)
            {
                if( board[r][c] == 1){
                   adaQueen = true;
                   break;
                }
            }
            
            r = i-1;
            int c = col-1;
            while( r >= 0 && c >= 0){
                if( board[r][c] == 1){
                    adaQueen = true;
                    break;
                }
                r--;c--;
            }
            r = i+1;
            c = col-1;
            while ( r <= N-1 && c >= 0){
                if ( board[r][c] == 1){
                    adaQueen = true;
                    break;
                }
                r++; c--;
            }
            if(!adaQueen){
                result.add(i);
            }
        }
        return result;
    }
    private void printBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        EightQueens queen = new EightQueens();
        queen.runAlgorithm();
    }
}

