package fise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraFisaNoua extends JFrame {

    private GestorEvenimenteB e;
    private JTextField fn,fp,fdn,fc,fv,fs,fa,fdr,fr1,fr2,tr;
    private JButton add,cancel;

    public FereastraFisaNoua(){
        super("Fisa noua");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(11,1,10,10));
        p.setBackground(Color.CYAN);

        p.add(new JLabel("Nume:"));
        fn=new JTextField(20);
        p.add(fn);

        p.add(new JLabel("Prenume:"));
        fp=new JTextField(20);
        p.add(fp);

        p.add(new JLabel("Data nastere:"));
        fdn=new JTextField(20);
        p.add(fdn);

        p.add(new JLabel("CNP:"));
        fc=new JTextField(20);
        p.add(fc);

        p.add(new JLabel("Varsta:"));
        fv=new JTextField(20);
        p.add(fv);

        p.add(new JLabel("Sex(M/F):"));
        fs=new JTextField(20);
        p.add(fs);

        p.add(new JLabel("Adresa:"));
        fa=new JTextField(20);
        p.add(fa);

        p.add(new JLabel("Data recoltarii:"));
        fdr=new JTextField(20);
        p.add(fdr);

        p.add(new JLabel("Rezultat analiza 1:"));
        fr1=new JTextField(20);
        p.add(fr1);

        p.add(new JLabel("Rezultat analiza 2:"));
        fr2=new JTextField(20);
        p.add(fr2);

        p.add(new JLabel("Tratament:"));
        tr=new JTextField(20);
        p.add(tr);

        add(p);
        p=new JPanel();
        e=new GestorEvenimenteB();
        add=new JButton("Adauga");
        add.addActionListener(e);
        p.add(add);

        cancel=new JButton("Cancel");
        cancel.addActionListener(e);
        p.add(cancel);

        add(p,BorderLayout.SOUTH);
    }

    private class GestorEvenimenteB implements ActionListener{

        ColectieFise cof;

        private GestorEvenimenteB(){
            cof = ColectieFise.getInstanta();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==add){
                cof.adaugaFisa(fn.getText(), fp.getText(), fdn.getText(), fc.getText(), fv.getText(), fs.getText(), fa.getText(), fdr.getText(), fr1.getText(), fr2.getText(),tr.getText());
                ColectieFise cf=ColectieFise.getInstanta();
                cf.salveazaF();
            }else FereastraFisaNoua.this.dispose();
        }
    }
}

