package persoane;

import buletin.*;
import cerere.FereastraCereriRezolvate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraChimist extends JFrame {

    private GestorEvenimenteC ge;
    JButton b1, b2, b3;
    JTextField t;


    public FereastraChimist() {

        super("Fereastra Chimist");

        JPanel p = new JPanel(new GridLayout(1, 3, 10, 10));
        p.setBackground(Color.decode("#C32BAD"));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ge = new GestorEvenimenteC();

        b1 = new JButton("Adauga");
        b1.addActionListener(ge);
        p.add(b1);

        b2 = new JButton("Afiseaza buletine");
        b2.addActionListener(ge);
        p.add(b2);

        b3 = new JButton("Afiseaza cereri");
        b3.addActionListener(ge);
        p.add(b3);

        add(p);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class GestorEvenimenteC implements ActionListener {

        JFrame f;
        ColectieBuletine cb;

        GestorEvenimenteC() {
            cb = ColectieBuletine.getInstanta();
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == b1) {

                f = new FereastraBuletinNou();
                f.setVisible(true);
                f.setSize(400, 400);

            }

            if (e.getSource() == b2) {
                f = new FereastraBuletine();
                f.setVisible(true);
                f.setSize(500, 200);
            }
            if (e.getSource() == b3) {
                f = new FereastraCereriRezolvate();
                f.setVisible(true);
                f.setSize(200, 200);
            }
        }
    }
}
