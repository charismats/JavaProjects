/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mst.src;

import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class Boruvka {

    private int[][] graph = {
        {0, 7, 0, 5, 0, 0, 0},
        {7, 0, 8, 9, 7, 0, 0},
        {0, 8, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9},
        {0, 0, 0, 6, 8, 0, 11},
        {0, 0, 0, 0, 9, 11, 0}
    };

    private ArrayList<Tree> Trees;
    private ArrayList<Edge> MSTEdges;
    private ArrayList<Edge> Edges;
    ArrayList<Tree> finalTree;

    public Boruvka() {
        Trees = new ArrayList<>();
        MSTEdges = new ArrayList<>();
        Edges = new ArrayList<>();
        //initialize Tree with minimum edge
        generateMinEdgeInsideTree();
    }

    private void generateMinEdgeInsideTree() {
        for (int i = 0; i < graph.length; i++) {

            int minWeight = Integer.MAX_VALUE;
            int j = 0;
            int neighbour = 0;
            for (; j < graph[i].length; j++) {
                if (graph[i][j] > 0 && minWeight > graph[i][j] && !InMST(i, j)) {
                    minWeight = graph[i][j];
                    neighbour = j;
                }
                //System.out.println(j);
            }

            Edge e = new Edge(i, neighbour, minWeight);
            //System.out.println(j+"Edge : "+e);
            Tree t = new Tree(i);
            t.minEdge = e;
            Trees.add(t);

        }
    }

    private boolean checkMSTComplete() {
        int count = 0;
        for (Tree t : finalTree) {
            if (count < t.getComponents().size()) {
                count = t.getComponents().size();
            }
        }
        return count >= graph.length;
    }

    private Edge findEdge(int i, int j) {
        for (Edge e : Edges) {
            if (e.v1 == i && e.v2 == j) {
                return e;
            }
        }
        return null;
    }

    public void runAlgo() {
        //System.out.println("RUNNING NEW ALGORITHM");
        finalTree = new ArrayList<>();
        while (!checkMSTComplete()) {
            Tree t = Trees.remove(0);
            Edge minEdge = t.minEdge;
            int v1 = minEdge.v1;
            int v2 = minEdge.v2;
            //System.out.println("MinEdge = " + minEdge);
            if (finalTree.isEmpty()) {
                t.addComponent(v2);
                finalTree.add(t);
                MSTEdges.add(minEdge);

            } else {
                if (!checkCycle(v1, v2)) {
                    Tree rootTree = findRootTreeInFinal(v1, v2);
                    if (rootTree != null) {
                        if (!isSameTreeinFinal(v1, v2)) {
                            joinTree(v1, v2);
                            MSTEdges.add(minEdge);
                        }
                        rootTree.addComponent(v1);
                        rootTree.addComponent(v2);
                    } else {
                        t.addComponent(v2);
                        MSTEdges.add(minEdge);
                        finalTree.add(t);
                    }
                }
            }
            if (Trees.isEmpty()) {
                generateMinEdgeInsideTree();
            }
            // printTree(finalTree);
        }
        System.out.println("Boruvka Finished");
        printMST();
    }

    private void printTree(ArrayList<Tree> trees) {
        for (Tree t : trees) {
            System.out.print("[");
            for (int comp : t.getComponents()) {
                System.out.print(comp + " ");
            }
            System.out.println("]");
        }
    }

    private void joinTree(int a, int b) {
        Tree one = getTree(a), two = getTree(b);
        if (one != null && two != null) {
            for (int comp : two.getComponents()) {
                one.addComponent(comp);
            }
            for (int comp : one.getComponents()) {
                two.addComponent(comp);
            }
        }
        //finalTree.remove(two);
    }

    private Tree getTree(int a) {
        Tree one = null;
        for (Tree t : finalTree) {
            for (int comp : t.getComponents()) {
                if (comp == a) {
                    one = t;
                    break;
                }
            }

        }
        return one;
    }

    private boolean isSameTreeinFinal(int a, int b) {
        Tree one = getTree(a), two = getTree(b);
        return one == two;
    }

    private Tree findRootTreeInFinal(int a, int b) {
        for (Tree t : finalTree) {
            for (int comp : t.getComponents()) {
                if (comp == a || comp == b) {
                    return t;
                }
            }
        }
        return null;
    }

    private boolean checkCycle(int a, int b) {
        for (Tree t : finalTree) {
            int count = 0;
            for (int comp : t.getComponents()) {
                if (comp == a || comp == b) {
                    count++;
                }
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean InMST(int a, int b) {
        for (Edge e : MSTEdges) {
            if ((e.v1 == a && e.v2 == b) || (e.v2 == a && e.v1 == b)) {
                return true;
            }
        }
        return false;
    }

    private void printMST() {
        System.out.println("MST contains vertices : ");
        Tree t = finalTree.get(0);
        for (int comp : t.getComponents()) {
            char v = (char) (comp + 'A');
            System.out.println("Vertice : " + v);
            //System.out.println(comp);
        }
        System.out.println("Edges in MST");
        for (Edge e : MSTEdges) {
            //System.out.println(e);
            char V1 = (char) (e.v1 + 'A');
            char V2 = (char) (e.v2 + 'A');
            System.out.println(V1 + " -> " + V2 + " = " + e.w);
        }
    }

    public static void main(String[] args) {
        Boruvka boruvka = new Boruvka();
        boruvka.runAlgo();
    }
}
