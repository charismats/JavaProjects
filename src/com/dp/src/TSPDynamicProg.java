/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.src;

/**
 *
 * @author Charisma
 */
import java.util.Arrays;

public class TSPDynamicProg {

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

    static int n = cities.length;

    // Jumlah kemungkinan subset kota
    static int SIZE = 1 << n;

    static double[][] dp = new double[SIZE][n];
    static int[][] parent = new int[SIZE][n];

    // =====================================
    // 2. MENGHITUNG JARAK ANTAR KOTA
    // =====================================
    static double distance(int i, int j) {
        return graph[i][j];
    }

    // =====================================
    // 3. INISIALISASI DP
    // =====================================
    static void initialize() {
        for (int mask = 0; mask < SIZE; mask++) {
            Arrays.fill(dp[mask], Double.POSITIVE_INFINITY);
            Arrays.fill(parent[mask], -1);
        }

        // Mulai dari kota A (indeks 0)
        dp[1][0] = 0;
    }

    // =====================================
    // 4. PROSES DYNAMIC PROGRAMMING
    // =====================================
    static void solveTSP() {

        initialize();

        for (int mask = 1; mask < SIZE; mask++) {

            // Kota terakhir saat ini
            for (int u = 0; u < n; u++) {

                // Lewati jika kota u belum dikunjungi
                if ((mask & (1 << u)) == 0) {
                    continue;
                }

                if (dp[mask][u] == Double.POSITIVE_INFINITY) {
                    continue;
                }

                // Coba kunjungi kota berikutnya
                for (int v = 0; v < n; v++) {

                    // Lewati jika kota v sudah dikunjungi
                    if ((mask & (1 << v)) != 0) {
                        continue;
                    }

                    int nextMask = mask | (1 << v);

                    double newDistance
                            = dp[mask][u] + distance(u, v);

                    if (newDistance < dp[nextMask][v]) {
                        dp[nextMask][v] = newDistance;
                        parent[nextMask][v] = u;
                    }
                }
            }
        }
    }

    // =====================================
    // 5. MENENTUKAN RUTE OPTIMAL
    // =====================================
    static void printOptimalRoute() {

        int fullMask = SIZE - 1;

        double minDistance = Double.POSITIVE_INFINITY;
        int lastCity = -1;

        // Cari kota terakhir terbaik sebelum kembali ke A
        for (int i = 1; i < n; i++) {

            double totalDistance
                    = dp[fullMask][i] + distance(i, 0);

            if (totalDistance < minDistance) {
                minDistance = totalDistance;
                lastCity = i;
            }
        }

        // Rekonstruksi rute dari tabel parent
        int[] route = new int[n + 1];

        int mask = fullMask;
        int current = lastCity;

        for (int i = n - 1; i >= 1; i--) {
            route[i] = current;

            int previous = parent[mask][current];

            mask ^= (1 << current);
            current = previous;
        }

        route[0] = 0;
        route[n] = 0;

        // Tampilkan hasil
        System.out.println("=== HASIL TSP DYNAMIC PROGRAMMING ===");

        System.out.print("Rute optimal: ");

        for (int i = 0; i <= n; i++) {
            System.out.print(cities[route[i]]);

            if (i < n) {
                System.out.print(" -> ");
            }
        }

        System.out.printf(
                "%nTotal jarak minimum: %.3f%n",
                minDistance
        );
    }

    // =====================================
    // 6. PROGRAM UTAMA
    // =====================================
    public static void main(String[] args) {

        solveTSP();

        printOptimalRoute();
    }
}
