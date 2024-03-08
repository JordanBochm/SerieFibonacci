/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.util.Stack;

class HanoiPanel extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private int numDiscos;
    private Stack<Integer>[] torres;

    public HanoiPanel(int numDiscos) {
        this.numDiscos = numDiscos;
        this.torres = new Stack[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }
        for (int i = numDiscos; i > 0; i--) {
            torres[0].push(i);
        }
    }

    public void resolverHanoi(int n, int torreInicio, int torreAuxiliar, int torreDestino) {
        if (n > 0) {
            resolverHanoi(n - 1, torreInicio, torreDestino, torreAuxiliar);
            int disco = torres[torreInicio].pop();
            torres[torreDestino].push(disco);
            repaint();
            try {
                Thread.sleep(500); // Agrega un pequeño retraso para una mejor visualización
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resolverHanoi(n - 1, torreAuxiliar, torreInicio, torreDestino);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int torreWidth = WIDTH / 3;
        int torreHeight = HEIGHT - 50;
        int discoHeight = 20;

        for (int i = 0; i < 3; i++) {
            g.drawRect(i * torreWidth, HEIGHT - torreHeight, torreWidth, torreHeight);
            int x = i * torreWidth + torreWidth / 2;
            int y = HEIGHT - 30;
            for (int disco : torres[i]) {
                g.setColor(Color.BLUE); // Puedes cambiar el color de los discos según tus preferencias
                g.fillRect(x - disco * 10, y - discoHeight, disco * 20, discoHeight);
                y -= discoHeight;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Torres de Hanoi");
            HanoiPanel hanoiPanel = new HanoiPanel(9); // Puedes cambiar el número de discos aquí
            frame.add(hanoiPanel);
            frame.setSize(WIDTH, HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            hanoiPanel.resolverHanoi(3, 0, 1, 2); // Resolver Torres de Hanoi
        });
    }
}
