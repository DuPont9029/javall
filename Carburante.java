import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Carburante {
    
    public static class Distributore {
        double benzina = 0;
        double europerlitro;
        JFrame finestra;
        Container container;

        public Distributore() {
            rifornisci(420);
            finestra = new JFrame("F.L.D.D SIMULATOR");
            container = finestra.getContentPane();
            container.setLayout(new GridBagLayout()); // Cambia il layout manager

            JButton pulsante = new JButton("NUKE RUSSIA") {
                @Override
                protected void paintComponent(Graphics g) {
                    if (getModel().isArmed()) {
                        g.setColor(Color.lightGray);
                    } else {
                        g.setColor(getBackground());
                    }
                    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
                    super.paintComponent(g);
                }

                @Override
                protected void paintBorder(Graphics g) {
                    g.setColor(getForeground());
                    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
                }

                @Override
                public boolean contains(int x, int y) {
                    return new Ellipse2D.Float(0, 0, getWidth(), getHeight()).contains(x, y);
                }
            };
            pulsante.setContentAreaFilled(false);
            pulsante.setFocusPainted(false);
            pulsante.setBackground(Color.RED);
            pulsante.setPreferredSize(new Dimension(150, 150)); // Imposta le dimensioni del pulsante

            pulsante.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StartScreen();
                }
            });

            container.add(pulsante);

            finestra.setSize(600,600);
            finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            finestra.setLocationRelativeTo(null);
            finestra.setVisible(true);
        }

        public void StartScreen() {
            JFrame finestra1 = new JFrame("distributore di benzina");
            Container container1 = finestra1.getContentPane();
            container1.setLayout(new GridLayout());

            JLabel labelBenzina = new JLabel("benzina disponibile: " + benzina);
            container1.add(labelBenzina); // Aggiungi questa riga

            finestra1.setSize(600,600);
            finestra1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            finestra1.setLocationRelativeTo(null);
            finestra1.setVisible(true);
        }

        private void rifornisci(double a) {
            this.benzina = this.benzina + a;
        }

        private void vendi(double a) {
            if(a <= this.benzina) {
                this.benzina = this.benzina - a;
            }
            else {
                JOptionPane.showMessageDialog(null, "Non c'è abbastanza benzina!", "Attenzione", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        new Distributore();
    }
}
