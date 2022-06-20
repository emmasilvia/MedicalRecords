package cerere;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FereastraStergereCerere extends JFrame{
    private GestorEvenimenteFF ec;
    private JTextField t;
    private JButton ok, c;
    public FereastraStergereCerere(){
        super ("Sterge o cerere");
        JPanel p=new JPanel();
        p.setBackground(Color.lightGray);
        p.add(new JLabel("Introduceti nume si prenume"));
        t=new JTextField(30);
        p.add(t);
        add(p);
        p=new JPanel();
        ec=new GestorEvenimenteFF();
        ok=new JButton("OK");
        ok.addActionListener(ec);
        p.add(ok);
        c=new JButton("Cancel");
        c.addActionListener(ec);
        p.add(c);
        add(p, BorderLayout.SOUTH);
        setSize(300,100);
        setLocation(300,300);
    }
    private class GestorEvenimenteFF implements ActionListener{
        private ColectieCereri colectieCereri;
        GestorEvenimenteFF(){ colectieCereri=ColectieCereri.getInstanta(); }
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==ok) {
                colectieCereri.stergeCerere(t.getText());
                t.setText("");
                ColectieCereri co = ColectieCereri.getInstanta();
                co.salveaza();
            }
            else FereastraStergereCerere.this.dispose();
        } }}
