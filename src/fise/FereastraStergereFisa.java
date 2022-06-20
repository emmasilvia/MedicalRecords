package fise;

import cerere.ColectieCereri;
import cerere.FereastraStergereCerere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraStergereFisa extends JFrame{

        private GestorEvenimenteSF e;
        private JTextField t;
        private JButton ok, c;
        public FereastraStergereFisa(){
            super ("Sterge o fisa");
            JPanel p=new JPanel();
            p.setBackground(Color.lightGray);
            p.add(new JLabel("Introduceti nume si prenume"));
            t=new JTextField(30);
            p.add(t);
            add(p);
            p=new JPanel();
            e=new GestorEvenimenteSF();
            ok=new JButton("OK");
            ok.addActionListener(e);
            p.add(ok);
            c=new JButton("Cancel");
            c.addActionListener(e);
            p.add(c);
            add(p, BorderLayout.SOUTH);
            setSize(300,100);
            setLocation(300,300);
        }
        private class GestorEvenimenteSF implements ActionListener {
            private ColectieFise colectieFise;
            GestorEvenimenteSF(){ colectieFise=ColectieFise.getInstanta(); }
            public void actionPerformed(ActionEvent e){
                if (e.getSource()==ok) {
                    colectieFise.stergeFise(t.getText());
                    t.setText("");
                    ColectieFise co = ColectieFise.getInstanta();
                    co.salveazaF();
                }
                else FereastraStergereFisa.this.dispose();
            }
        }
}


