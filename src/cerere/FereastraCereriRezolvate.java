package cerere;
import javax.swing.*;
import java.awt.*;


public class FereastraCereriRezolvate extends JFrame {

    private ColectieCereriRezolvate ccr;
    private JTextArea ta;

    public FereastraCereriRezolvate(){
        super("Colectie cereri rezolvate");
        add(new JLabel("Toate cererile rezolvate:"), BorderLayout.NORTH);

        ta=new JTextArea(20,200);
        ccr=ColectieCereriRezolvate.getInstanta();
        ta.setText(ccr.getCereriRezolvate());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
