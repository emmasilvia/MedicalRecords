package persoane;

import buletin.FereastraBuletine;
import cerere.FereastraCerereNoua;
import cerere.FereastraCereri;
import cerere.FereastraStergereCerere;
import fise.FereastraFisaNoua;
import fise.FereastraFise;
import fise.FereastraStergereFisa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FereastraMedic extends JFrame{
    private GestorEvenimenteM e;
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;


    public FereastraMedic(){

        super("Fereastra Medic");

        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBackground(Color.decode("#7027A0"));
        JPanel p = new JPanel(new GridLayout(1,3,10,10));
        p.setBackground(Color.decode("#7027A0"));
        JPanel p2 = new JPanel(new GridLayout(1,1,10,10));
        p2.setBackground(Color.decode("#7027A0"));
        JPanel p3 = new JPanel(new GridLayout(1,3,10,10));
        p3.setBackground(Color.decode("#7027A0"));
        JPanel p4 = new JPanel(new GridLayout(1,2,10,10));
        p4.setBackground(Color.decode("#7027A0"));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        l1=new JLabel("Bine ati venit! Alegeti o optiune: ");
        panel.add(l1);

        e = new GestorEvenimenteM();

        b1 = new JButton("Adauga cerere");
        b1.addActionListener(e);
        p.add(b1);


        b2 = new JButton("Afiseaza cereri");
        b2.addActionListener(e);
        p.add(b2);

        b3 = new JButton("Stergere cerere");
        b3.addActionListener(e);
        p.add(b3);
        panel.add(p);

        b5=new JButton("Afiseaza buletine: ");
        b5.addActionListener(e);
        p2.add(b5);
        panel.add(p2);


        b4 = new JButton("Creeaza fisa");
        b4.addActionListener(e);
        p3.add(b4);

        b6=new JButton("Afiseaza fise: ");
        b6.addActionListener(e);
        p3.add(b6);

        b7=new JButton("Sterge Fisa");
        b7.addActionListener(e);
        p3.add(b7);

        panel.add(p3);

        b8=new JButton("Adauga pacient");
        b8.addActionListener(e);
        p4.add(b8);

        b9=new JButton("Sterge pacient");
        b9.addActionListener(e);
        p4.add(b9);
        panel.add(p4);

        add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private class GestorEvenimenteM implements ActionListener{
        private JFrame f;

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b1){
                f = new FereastraCerereNoua();
                f.setSize(500,300);
                f.setVisible(true);
            } else if(e.getSource() == b2) {
                f = new FereastraCereri();
                f.setSize(500,300);
                f.setVisible(true);
            }else if(e.getSource() == b3){
                f = new FereastraStergereCerere();
                f.setSize(500,300);
                f.setVisible(true);
            }else if(e.getSource()==b4){
                f = new FereastraFisaNoua();
                f.setSize(600,600);
                f.setVisible(true);
            }else if(e.getSource()==b5){
                f = new FereastraBuletine();
                f.setSize(500,300);
                f.setVisible(true);
            }else if(e.getSource()==b6){
                f = new FereastraFise();
                f.setSize(500,300);
                f.setVisible(true);
            }else if(e.getSource()==b7){
                f = new FereastraStergereFisa();
                f.setSize(400,300);
                f.setVisible(true);
            }else if(e.getSource()==b8){
                f = new FereastraPacientNou();
                f.setSize(400,400);
                f.setVisible(true);
            }else if(e.getSource()==b9){
                f = new FereastraStergerePacient();
                f.setSize(400,300);
                f.setVisible(true);
            }
        }
    }
}
