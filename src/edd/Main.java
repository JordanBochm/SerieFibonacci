/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import javax.swing.SwingUtilities;

/**
 *
 * @author HP
 */
public class Main
{
    public static void main(String[] args)
    {
      
           // Crear e iniciar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FibonacciFrame().setVisible(true);
            }
        });
    }
    }

