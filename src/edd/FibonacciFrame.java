/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

    
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class FibonacciFrame extends JFrame {

    private static final int LIMITE_NUMERO = 30; // Establecer el límite permitido

    private JLabel titleLabel, inputLabel, resultLabel;
    private JTextField inputTextField;
    private JTextArea resultTextArea;
    private JScrollPane scrollPane;

    public FibonacciFrame() {
        // Configuración del frame
        setTitle("Serie Fibonacci");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra el frame en la pantalla
        setResizable(false); // Deshabilita la posibilidad de redimensionar el frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 240, 240)); // Color de fondo

        // Crear y configurar componentes
        titleLabel = new JLabel("Serie Fibonacci");
        inputLabel = new JLabel("Coloque un número:");
        resultLabel = new JLabel("Proceso de la serie:");

        inputTextField = new JTextField();
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        scrollPane = new JScrollPane(resultTextArea);

        // Establecer colores
        titleLabel.setForeground(new Color(0, 102, 204)); // Azul oscuro
        inputLabel.setForeground(new Color(0, 102, 204));
        resultLabel.setForeground(new Color(0, 102, 204));
        inputTextField.setBackground(new Color(255, 255, 255)); // Blanco
        resultTextArea.setBackground(new Color(255, 255, 255));
        resultTextArea.setForeground(new Color(0, 102, 0)); // Verde oscuro

        // Posicionar componentes
        titleLabel.setBounds(150, 10, 150, 30);
        inputLabel.setBounds(20, 50, 150, 30);
        inputTextField.setBounds(180, 50, 100, 30);
        resultLabel.setBounds(20, 90, 150, 30);
        scrollPane.setBounds(20, 120, 350, 100);

        // Agregar componentes al frame
        add(titleLabel);
        add(inputLabel);
        add(inputTextField);
        add(resultLabel);
        add(scrollPane);

        // Agregar un ActionListener al campo de texto
        inputTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTextField.setText("");
            }
        });

        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el número ingresado por el usuario
                try {
                    int n = Integer.parseInt(inputTextField.getText());

                    // Validar el límite permitido
                    if (n > LIMITE_NUMERO) {
                        JOptionPane.showMessageDialog(null, "El número ingresado supera el límite permitido",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Generar y mostrar la serie Fibonacci
                    generarSerieFibonacci(n);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void generarSerieFibonacci(int n) {
        int a = 0, b = 1;
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < n; i++) {
            resultado.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");

            int temp = a + b;
            a = b;
            b = temp;
        }

        resultTextArea.setText(resultado.toString());
    }
}


