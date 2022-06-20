package cerere;

import cerere.ColectieCereri;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class FereastraCereri extends JFrame{
    private JTextArea ta;
    private ColectieCereri cc;
    public FereastraCereri(){
        super ("Cereri");
        add(new JLabel("Toate fisele"), BorderLayout.NORTH);
        ta=new JTextArea(20,200);
        cc=ColectieCereri.getInstanta();
        ta.setText(cc.getCereri());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}