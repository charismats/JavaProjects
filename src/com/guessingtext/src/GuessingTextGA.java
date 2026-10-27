/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessingtext.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Charisma
 */
public class GuessingTextGA {

    public String correct_text;
    public String solution_text = "";
    public ArrayList<Individual> population;
    public int NUM_POPULATION = 7;
    Random rnd;

    public GuessingTextGA(String text) {
        correct_text = text;
        rnd = new Random();
        generateRandomPopulation();
    }

    public void doAlgorithm() {
        System.out.println("Random Population: ");
        Individual bestIndividu = population.get(0);
        while (!bestIndividu.text.equals(correct_text)) {
            printPopulation(population);
            selectParents();
            mutation(population);
            System.out.println("Mutation : ");
            printPopulation(population);
            bestIndividu = population.get(0);
        }
        System.out.println("Solution Found: Text Found : "+bestIndividu.text);
        solution_text = bestIndividu.text;
    }

    //1.step population generation
    public void generateRandomPopulation() {
        population = new ArrayList<>();
        for (int i = 0; i < NUM_POPULATION; i++) {
            int lengthString = correct_text.length();
            String guess = "";
            for (int j = 0; j < lengthString; j++) {
                int rndNum = rnd.nextInt(27);
                if (rndNum == 26) {
                    guess += " ";
                } else {
                    guess += (char) (rndNum + 'a');
                }
            }
            Individual individu = new Individual(guess);
            individu.calculateFitness(correct_text);
            population.add(individu);
        }
        //sort population based on fitness reverse order
        Collections.sort(population, Collections.reverseOrder());
    }

    //2. Select 2 parent from the population
    public void selectParents() {
        Individual parent1 = population.get(0);
        Individual parent2 = population.get(1);
        ArrayList<Individual> children = crossOver(parent1, parent2);
        System.out.println("Cross Over result:");
        printPopulation(children);
        population = children;
    }

    public ArrayList<Individual> crossOver(Individual p1, Individual p2) {
        ArrayList<Individual> children = new ArrayList<>();

        for (int i = 0; i < NUM_POPULATION; i++) {
            int whichParent = rnd.nextInt(2);
            String parent = "";

            String childText = "";
            for (int j = 0; j < p1.text.length();) {
                if (whichParent == 0) {
                    parent = p1.text;
                } else {
                    parent = p2.text;
                }
                if (j + 4 <= p1.text.length() - 1) {
                    childText += parent.substring(j, j + 4);
                    j += 4;
                } else {
                    childText += parent.substring(j);
                    j = p1.text.length();
                }

            }
            Individual child = new Individual(childText);
            child.calculateFitness(correct_text);
            children.add(child);
        }
        return children;
    }

    public void mutation(ArrayList<Individual> children) {
        for (int i = 0; i < NUM_POPULATION; i++) {
            Individual ind = children.get(i);
            String text = ind.text;
            String newText = "";
            for (int j = 0; j < text.length(); j++) {
                int rate = rnd.nextInt(100);
                if (rate == 0) { //0.1 rate mutation
                    int rndNum = rnd.nextInt(27);
                    if (rndNum == 26) {
                        newText += " ";
                    } else {
                        newText += (char) (rndNum + 'a');
                    }
                } else {
                    newText += text.charAt(j);
                }
            }
            ind.text = newText;
            ind.calculateFitness(correct_text);
        }
         //sort population based on fitness reverse order
        Collections.sort(population, Collections.reverseOrder());
    }

    public void printPopulation(ArrayList<Individual> population) {
        for (int i = 0; i < population.size(); i++) {
            Individual ind = population.get(i);
            System.out.println((i + 1) + "-> " + ind);
        }
    }

    public static void main(String[] args) {
        String text = "saya pergi ke pasar saya mau membeli buah jeruk";
        GuessingTextGA gt = new GuessingTextGA(text);
        gt.doAlgorithm();
    }
}
