/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.longestcommonsubsequence.src;

/**
 *
 * @author Charisma
 */
public class LongestCommonSubsequence {
    public int doDP(String A, String B){
        int[][]Table = new int[A.length()+1][B.length()+1];
        for(int i = 0; i <= A.length();i++){
            for(int j = 0; j <= B.length(); j++){
                if( i == 0 || j == 0 )
                    Table[i][j] = 0;
                else if (A.charAt(i-1) == B.charAt(j-1)){
                    Table[i][j] = Table[i-1][j-1]+1;
                }else{
                    Table[i][j] = Math.max(Table[i-1][j], Table[i][j-1]);
                }
                    
                    
            }
        }
        return Table[A.length()][B.length()];
    }
    
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String A = "ABCDEH";
        String B = "AEDFHR";
        
        int longest = lcs.doDP(A, B);
        System.out.println("Longest Common Subsequence: "+longest);
    }
}
