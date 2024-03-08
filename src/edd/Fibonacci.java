/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class Fibonacci {

    // Función recursiva para calcular el n-ésimo término de la serie Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        // Imprimir los primeros 10 términos de la serie Fibonacci
        int n = 10;
        System.out.println("Serie Fibonacci de los primeros " + n + " términos:");

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        JFrame s= new  SerieFibonacci();
        s.setVisible(true);
    }
}
