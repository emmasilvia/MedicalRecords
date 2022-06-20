package persoane;

import cerere.ColectieCereri;
import fise.ColectieFise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraPacient extends JFrame {

    private JTextField t;
    private JButton b,cancel;
    private JTextArea ta;
    private GestorEvenimenteP e;

    public FereastraPacient(){
        super("Fereastra Pacient");

        JPanel p = new JPanel(new GridLayout(2,1,10,10));
        p.setBackground(Color.BLUE);
        e=new GestorEvenimenteP();

        t=new JTextField(20);
        p.add(t);

        b=new JButton("Afiseaza fisa medicala");
        b.addActionListener(e);
        p.add(b);

        ta=new JTextArea();
        p.add(ta);

        cancel=new JButton("Cancel");
        cancel.addActionListener(e);
        p.add(cancel);



        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class GestorEvenimenteP implements ActionListener{

        ColectieFise cf;

        GestorEvenimenteP() {
            cf = ColectieFise.getInstanta();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b){
                ta.setText(cf.cautaFisa(t.getText()));
                t.setText("");
            }else FereastraPacient.this.dispose();
        }
    }

}
