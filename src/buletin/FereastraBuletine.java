package buletin;

import cerere.ColectieCereri;

import javax.swing.*;
import java.awt.*;

public class FereastraBuletine extends JFrame {

    private JTextArea ta;
    private ColectieBuletine cb;
    public FereastraBuletine(){
        super ("Buletine");
        add(new JLabel("Toate fisele"), BorderLayout.NORTH);
        ta=new JTextArea(20,200);
        cb=ColectieBuletine.getInstanta();
        ta.setText(cb.getBuletine());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
