/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.metodoDeGausJordan.entidades;

import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class MetodosGJ {

    static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
                System.out.print(" " + matriz[x][y] + " |");
            }
            System.out.println("");
        }

    }

    static void pivote(float matriz[][], int piv, int var) {
        float temp = 0;
        temp = matriz[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matriz[piv][y] = matriz[piv][y] / temp;
        }
    }

    static void hacerceros(float matriz[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                float c = matriz[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int var = 0, piv = 0;
        float matriz[][];
        System.out.println("\t ** Este programa nos muestra la solución de un sistema de ecuaciones \n\t\tlineales a través del método Gauss_Jordan **");
        System.out.println("\n¿Cuantas variables tiene tu sistema?");
        var = leer.nextInt();
        matriz = new float[var][var + 1];
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
                System.out.println("Ingresa la constante de la posicion: A[" + (x + 1) + "][" + (y + 1) + "]");
                matriz[x][y] = leer.nextFloat();
            }

        }

        for (int a = 0; a < var; a++) {
            pivote(matriz, piv, var);

            System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatriz(matriz, var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(matriz, piv, var);

            muestramatriz(matriz, var);
            System.out.println("");
            piv++;
        }
        for (int x = 0; x < var; x++) {
            System.out.println("La variable X" + (x + 1) + " es: " + matriz[x][var]);
        }

    }
    
    
}
