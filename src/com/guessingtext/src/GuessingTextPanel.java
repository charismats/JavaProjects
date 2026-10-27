/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessingtext.src;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author Charisma
 */
public class GuessingTextPanel extends JPanel {

    GuessingTextGA gtga;
    public String correct_text = "saya pergi ke pasar";
    public String solution_text = "";
    public ArrayList<Individual> population;
    public int NUM_POPULATION = 7;
    Random rnd;

    String solution = "";
    JButton btnText;
    JButton btnSolve;
    JLabel textLabel;
    JLabel solutionLabel;
    JTextArea textArea;
    JScrollPane scrollPane;
    String textAreaContent = "";
    Timer timer;

    public GuessingTextPanel() {
        setLayout(new FlowLayout());
        btnText = new JButton("Change Text");
        add(btnText);
        btnText.addActionListener(e -> {
            correct_text = JOptionPane.showInputDialog("Enter text");
            textLabel.setText(correct_text);
        });

        textLabel = new JLabel(correct_text);
        add(textLabel);

        solutionLabel = new JLabel(solution);

        btnSolve = new JButton("Solve");
        add(btnSolve);
        add(solutionLabel);
        btnSolve.addActionListener(e -> {
            generateRandomPopulation();
            //gtga = new GuessingTextGA(correct_text);
            timer = new Timer(10, f -> {
                doAlgorithm();
                repaint();
            });
            //gtga.doAlgorithm();
            timer.start();
            solutionLabel.setText(solution_text);
        });

        textArea = new JTextArea(50, 60);
        textArea.setLineWrap(true);
        scrollPane = new JScrollPane(textArea);
        //add(textArea);
        add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rnd = new Random();

    }

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

    public void doAlgorithm() {
        Individual bestIndividu = population.get(0);
        if (!bestIndividu.text.equals(correct_text)) {
            //printPopulation(population);
            selectParents();
            mutation(population);
            textAreaContent += "Mutation : \n";
            //printPopulation(population);
            bestIndividu = population.get(0);
            solution_text = bestIndividu.text;
            solutionLabel.setForeground(Color.BLACK);
            solutionLabel.setText(solution_text);
            textArea.setText(textAreaContent);
            repaint();
        }
        if (solution_text.equals(correct_text)) {
            solutionLabel.setForeground(Color.GREEN);
            timer.stop();
            timer = null;
        }
    }

//2. Select 2 parent from the population
    public void selectParents() {
        Individual parent1 = population.get(0);
        Individual parent2 = population.get(1);
        ArrayList<Individual> children = crossOver(parent1, parent2);
        textAreaContent += "Cross Over result:\n";
        printPopulation(children);
        population = children;
        //textArea.setText(textAreaContent);
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
                if (text.charAt(j) != correct_text.charAt(j)) {
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
                }else{
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
            //System.out.println((i + 1) + "-> " + ind);
            textAreaContent += (i + 1) + "->" + ind + "\n";
        }
        textArea.setText(textAreaContent);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
