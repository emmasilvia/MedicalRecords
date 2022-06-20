import persoane.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FereastraPrincipala extends JFrame {

    private GestorEvenimenteFP g;
    private JButton b;
    private JLabel l,l1,l2;
    private JTextField n,cod;

    public FereastraPrincipala(){
        super("Fise Medicale");
        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(6,1,5,5));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        p1.setBackground(Color.decode("#1DB9C3"));

        l = new JLabel("Logati-va cu NumePrenume si cod:");
        l.setFont(new Font("Serif", Font.PLAIN,30));
        p1.add(l);

        l1 = new JLabel("Introduceti NumePrenume:");
        l1.setFont(new Font("Serif", Font.PLAIN,20));
        p1.add(l1);
        n = new JTextField(50);
        p1.add(n);

        l2 = new JLabel("Introduceti codul:");
        l2.setFont(new Font("Serif", Font.PLAIN,20));
        p1.add(l2);
        cod = new JTextField( 10);
        p1.add(cod);

        g= new GestorEvenimenteFP();
        b = new JButton("Login");
        b.addActionListener(g);
        p1.add(b);

        add(p1,BorderLayout.CENTER);
    }

    private class GestorEvenimenteFP implements ActionListener {

        private JFrame f;

        public void actionPerformed(ActionEvent e) {
            File fi = new File("medici.txt");
            File fi2 = new File("asistenti.txt");
            File fi3 = new File("chimisti.txt");
            File fi4 = new File("pacienti.txt");
            String k = n.getText();
            String k1 = cod.getText();

            if (fi.exists()) {
            try {
                Scanner br = new Scanner(new File("medici.txt"));
                while (br.hasNextLine()) {
                    String s = br.nextLine();
                    String[] sArray = s.split(",");

                    if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                        JOptionPane.showMessageDialog(null,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        f = new FereastraMedic();
                        f.setSize(600, 300);
                        f.setVisible(true);
                        FereastraPrincipala.this.dispose();
                    }
                }
                n.setText("");
                cod.setText("");
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            } else System.out.println("Nu exista fisierul");

            if (fi2.exists()) {
                try {
                    Scanner br = new Scanner(new File("asistenti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");
                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            JOptionPane.showMessageDialog(null,
                                    "Login Successful", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            f = new FereastraAsistent();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    n.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");

            if (fi3.exists()) {
                try {
                    Scanner br = new Scanner(new File("chimisti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");
                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            JOptionPane.showMessageDialog(null,
                                    "Login Successful", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            f = new FereastraChimist();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    n.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");

            if (fi4.exists()) {
                try {
                    Scanner br = new Scanner(new File("pacienti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");
                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            JOptionPane.showMessageDialog(null,
                                    "Login Successful", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            f = new FereastraPacient();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    n.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");
        }
    }

    public static void main(String[] args) {
        JFrame w = new FereastraPrincipala();
        w.setSize(600,500);
        w.setLocation(400,300);
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
