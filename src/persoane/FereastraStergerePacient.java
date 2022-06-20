package persoane;

import cerere.ColectieCereri;
import cerere.FereastraStergereCerere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraStergerePacient extends JFrame {

    private GestorEvenimenteSP ec;
    private JTextField t;
    private JButton ok, c;

    public FereastraStergerePacient() {
        super("Sterge o cerere");
        JPanel p = new JPanel();
        p.setBackground(Color.decode("#C32BAD"));
        p.add(new JLabel("Introduceti nume si prenume"));
        t = new JTextField(30);
        p.add(t);
        add(p);
        p = new JPanel();
        ec = new GestorEvenimenteSP();
        ok = new JButton("OK");
        ok.addActionListener(ec);
        p.add(ok);
        c = new JButton("Cancel");
        c.addActionListener(ec);
        p.add(c);
        add(p, BorderLayout.SOUTH);
        setSize(300, 100);
        setLocation(300, 300);
    }

    private class GestorEvenimenteSP implements ActionListener {
        private ColectiePacienti colectiePacienti;

        GestorEvenimenteSP() {
            colectiePacienti = ColectiePacienti.getInstanta();
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ok) {
                colectiePacienti.stergePacient(t.getText());
                t.setText("");
                ColectiePacienti co = ColectiePacienti.getInstanta();
                co.salveazaP();
            } else FereastraStergerePacient.this.dispose();
        }
    }
}
