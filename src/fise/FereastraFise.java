package fise;
import javax.swing.*;
import java.awt.*;

public class FereastraFise extends JFrame {

    private JTextArea ta;
    private ColectieFise cf;
    public FereastraFise(){
        super ("Fise");
        add(new JLabel("Toate fisele"), BorderLayout.NORTH);
        ta=new JTextArea(20,200);
        cf= ColectieFise.getInstanta();
        ta.setText(cf.getFise());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
