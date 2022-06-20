package persoane;

import cerere.ColectieCereri;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraAsistent extends JFrame {

    private GestorEvenimenteA ge;
    JButton b,b2;
    JTextField t;
    JTextArea ta;

    public FereastraAsistent(){
        super("Fereastra Asistent");
        JPanel p=new JPanel(new GridLayout(2,2,10,10));
        p.setBackground(Color.decode("#C32BAD"));

        ge=new GestorEvenimenteA();

        t = new JTextField(30);
        p.add(t);
        b= new JButton("Cauta");
        b.addActionListener(ge);
        p.add(b);
        ta = new JTextArea();
        p.add(ta);

        b2= new JButton("Adauga");
        b2.addActionListener(ge);
        p.add(b2);
        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class GestorEvenimenteA implements ActionListener{

        JFrame f;
        ColectieCereri cc;

        GestorEvenimenteA(){
            cc = ColectieCereri.getInstanta();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b){
                ta.setText(cc.cautaCerere(t.getText()));
                t.setText("");

            }
            if(e.getSource() == b2){
                cc.salveazaCerereRezolvata(t.getText());
                System.out.println("Cerere adaugata");
            }
        }
    }

}
