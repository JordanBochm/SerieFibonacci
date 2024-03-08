/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author HP
 */
public class TorresDeHanoi {

    // Método principal para resolver las Torres de Hanoi
    public static void resolverHanoi(int discos, char torreOrigen, char torreAuxiliar, char torreDestino) {
        if (discos == 1) {
            System.out.println("Mover disco 1 de " + torreOrigen + " a " + torreDestino);
        } else {
            resolverHanoi(discos - 1, torreOrigen, torreDestino, torreAuxiliar);
            System.out.println("Mover disco " + discos + " de " + torreOrigen + " a " + torreDestino);
            resolverHanoi(discos - 1, torreAuxiliar, torreOrigen, torreDestino);
        }
    }

    public static void main(String[] args) {
        int numDiscos = 3; // Puedes ajustar este valor según la cantidad de discos
        resolverHanoi(numDiscos, 'A', 'B', 'C');
    }
}
