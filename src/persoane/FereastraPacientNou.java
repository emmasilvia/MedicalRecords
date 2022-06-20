package persoane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraPacientNou extends JFrame {

    private GestorEvenimenteP ge;
    private JTextField np,cod;
    private JButton add,cancel;

    public FereastraPacientNou(){
        super("Adauga pacient nou");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1,10,10));
        p.setBackground(Color.decode("#C32BAD"));

        p.add(new JLabel("NumePrenume:"));
        np=new JTextField(40);
        p.add(np);

        p.add(new JLabel("Cod:"));
        cod=new JTextField(20);
        p.add(cod);

        add(p);

        ge=new GestorEvenimenteP();
        p=new JPanel();
        add=new JButton("Adauga");
        add.addActionListener(ge);
        p.add(add);

        cancel=new JButton("Cancel");
        cancel.addActionListener(ge);
        p.add(cancel);

        add(p,BorderLayout.SOUTH);
    }

    private class GestorEvenimenteP implements ActionListener{

        private ColectiePacienti cp;
        private JFrame f;
        GestorEvenimenteP(){
            cp=ColectiePacienti.getInstanta();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==add){
                cp.adaugaPacient(np.getText(),cod.getText());
                FereastraPacientNou.this.dispose();
                ColectiePacienti coP= ColectiePacienti.getInstanta();
                coP.salveazaP();
            }
            else FereastraPacientNou.this.dispose();
        }
    }
}
