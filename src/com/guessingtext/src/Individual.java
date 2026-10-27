/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessingtext.src;

/**
 *
 * @author Charisma
 */
public class Individual implements Comparable<Individual>{
    public String text;
    public int fitness;
    public Individual(String a){
        text = a;
        fitness = 0;
    }
    public void calculateFitness(String correct_text){
        fitness = 0;
        //System.out.println("text = "+text + " correct_text = "+correct_text);
        for(int i = 0; i < text.length(); i++){
            if( text.charAt(i) == correct_text.charAt(i)){
                fitness++;
            }
        }
    }

    @Override
    public String toString() {
        return "Individual{" + "text=" + text + ",length = " + text.length() +", fitness=" + fitness + '}';
    }

    @Override
    public int compareTo(Individual o) {
        if ( fitness > o.fitness )
            return 1;
        if ( fitness < o.fitness)
            return -1;
        return 0;
    }
}
