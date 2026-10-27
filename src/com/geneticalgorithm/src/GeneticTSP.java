/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geneticalgorithm.src;

/**
 *
 * @author Charisma
 */
import java.util.*;

public class GeneticTSP {

    // =====================================
    // 1. DATA KOTA
    // =====================================
    static String[] cities = {"1", "2", "3", "4", "5"};
    private static int[][] graph = {
        {0, 4, 7, 3, 6},
        {4, 0, 5, 8, 2},
        {7, 5, 0, 4, 3},
        {3, 8, 4, 0, 6},
        {6, 2, 3, 6, 0}
    };

    static final int POPULATION_SIZE = 10;
    static final int GENERATIONS = 100;
    static final double MUTATION_RATE = 0.1;
    static final int ELITE_SIZE = 2;
    static final int TOURNAMENT_SIZE = 5;

    static final Random random = new Random();
    static final int N = cities.length;

    // =====================================
    // 2. MENGHITUNG JARAK ANTAR KOTA
    // =====================================
    static double distance(int city1, int city2) {
        return graph[city1][city2];
    }

    // =====================================
    // 3. MENGHITUNG TOTAL JARAK RUTE
    // =====================================
    static double routeDistance(int[] route) {
        double total = 0;

        for (int i = 0; i < route.length; i++) {
            int current = route[i];
            int next = route[(i + 1) % route.length];

            total += distance(current, next);
        }

        return total;
    }

    double routeDistance1(int[] route) {
        double total = 0;

        for (int i = 0; i < route.length; i++) {
            int current = route[i];
            int next = route[(i + 1) % route.length];

            total += distance(current, next);
        }

        return total;
    }

    // =====================================
    // 4. MEMBUAT INDIVIDU SECARA ACAK
    // =====================================
    static int[] createIndividual() {
        int[] route = new int[N];

        for (int i = 0; i < N; i++) {
            route[i] = i;
        }

        // Fisher-Yates shuffle
        for (int i = N - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            int temp = route[i];
            route[i] = route[j];
            route[j] = temp;
        }

        return route;
    }

    // =====================================
    // 5. MEMBUAT POPULASI AWAL
    // =====================================
    static List<int[]> createPopulation() {
        List<int[]> population = new ArrayList<>();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            population.add(createIndividual());
        }

        return population;
    }

    // =====================================
    // 6. SELEKSI: TOURNAMENT SELECTION
    // =====================================
    static int[] selection(List<int[]> population) {
        int[] best = null;
        double bestDistance = Double.POSITIVE_INFINITY;

        for (int i = 0; i < TOURNAMENT_SIZE; i++) {
            int index = random.nextInt(population.size());
            int[] candidate = population.get(index);

            double d = routeDistance(candidate);

            if (d < bestDistance) {
                bestDistance = d;
                best = candidate;
            }
        }

        return best.clone();
    }

    // =====================================
    // 7. CROSSOVER: ORDERED CROSSOVER (OX)
    // =====================================
    static int[] crossover(int[] parent1, int[] parent2) {
        int[] child = new int[N];
        Arrays.fill(child, -1);

        int start = random.nextInt(N);
        int end = random.nextInt(N);

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        // Salin sebagian gen dari parent 1
        for (int i = start; i <= end; i++) {
            child[i] = parent1[i];
        }

        // Isi gen yang tersisa berdasarkan parent 2
        int position = (end + 1) % N;

        for (int i = 0; i < N; i++) {
            int city = parent2[(end + 1 + i) % N];

            if (!contains(child, city)) {
                child[position] = city;
                position = (position + 1) % N;
            }
        }

        return child;
    }

    static boolean contains(int[] route, int city) {
        for (int gene : route) {
            if (gene == city) {
                return true;
            }
        }

        return false;
    }

    // =====================================
    // 8. MUTASI: SWAP MUTATION
    // =====================================
    static int[] mutate(int[] route) {
        int[] mutated = route.clone();

        if (random.nextDouble() < MUTATION_RATE) {
            int i = random.nextInt(N);
            int j = random.nextInt(N);

            while (i == j) {
                j = random.nextInt(N);
            }

            int temp = mutated[i];
            mutated[i] = mutated[j];
            mutated[j] = temp;
        }

        return mutated;
    }

    // =====================================
    // 9. ALGORITMA GENETIC ALGORITHM
    // =====================================
    static int[] geneticAlgorithm() {
        List<int[]> population = createPopulation();

        int[] bestRoute = null;
        double bestDistance = Double.POSITIVE_INFINITY;

        for (int generation = 0;
                generation < GENERATIONS;
                generation++) {

            // Urutkan populasi berdasarkan jarak
            population.sort(Comparator.comparingDouble(GeneticTSP::routeDistance));

            // Simpan solusi terbaik
            double currentBestDistance
                    = routeDistance(population.get(0));

            if (currentBestDistance < bestDistance) {
                bestDistance = currentBestDistance;
                bestRoute = population.get(0).clone();
            }

            // Tampilkan perkembangan
            if (generation % 50 == 0) {
                System.out.printf(
                        "Generasi %d | Jarak terbaik: %.3f%n",
                        generation,
                        bestDistance
                );
            }

            // Elitisme
            List<int[]> newPopulation = new ArrayList<>();

            for (int i = 0; i < ELITE_SIZE; i++) {
                newPopulation.add(population.get(i).clone());
            }

            // Membentuk generasi baru
            while (newPopulation.size() < POPULATION_SIZE) {
                int[] parent1 = selection(population);
                int[] parent2 = selection(population);

                int[] child = crossover(parent1, parent2);
                child = mutate(child);

                newPopulation.add(child);
            }

            population = newPopulation;
        }

        return bestRoute;
    }

    // =====================================
    // 10. MENAMPILKAN HASIL
    // =====================================
    static void printRoute(int[] route) {
        for (int i = 0; i < route.length; i++) {
            System.out.print(cities[route[i]] + " -> ");
        }

        // Kembali ke kota awal
        System.out.println(cities[route[0]]);
    }

    public static void main(String[] args) {
        int[] bestRoute = geneticAlgorithm();

        double bestDistance = routeDistance(bestRoute);

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.print("Rute terbaik: ");
        printRoute(bestRoute);

        System.out.printf(
                "Total jarak: %.3f%n",
                bestDistance
        );
    }
}
