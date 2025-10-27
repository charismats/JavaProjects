/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.longestcommonsubstring.src;

/**
 *
 * @author Charisma
 */
public class LongestCommonSubstring {
    public int doDP(String A, String B){
        int[][]Table = new int[A.length()+1][B.length()+1];
        int longest = 0;
        for(int i = 0; i <= A.length(); i++){
            for(int j = 0; j <= B.length(); j++){
                if( i == 0 || j == 0 )
                    Table[i][j] = 0;
                else if ( A.charAt(i-1) == B.charAt(j-1)){
                    Table[i][j] = Table[i-1][j-1] +1;
                    if( longest < Table[i][j])
                        longest = Table[i][j];
                }else
                    Table[i][j] = 0;
                    
            }
        }
        return longest;
    }
    
    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String A = "familyone";
        String B = "emilyioe";
        int longest = lcs.doDP(A, B);
        System.out.println("Longest Common Substring : "+longest);
        
    }
}
