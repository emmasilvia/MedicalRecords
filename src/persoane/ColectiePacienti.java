package persoane;

import cerere.Cerere;
import cerere.ColectieCereri;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ColectiePacienti {

    private TreeSet<Pacient> ts;
    private BufferedReader br;
    private String l;
    private Pacient pacient;

    private static ColectiePacienti instanta;

    private ColectiePacienti(){
        File f = new File("pacienti.txt");
        ts = new TreeSet<>();
        String[] s;
        if(f.exists()){
            try {
                br=new BufferedReader(new FileReader(f));
                while ((l=br.readLine())!=null){
                    s=l.split(",");
                    pacient=new Pacient(s[0],s[1]);
                    ts.add(pacient);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else System.out.println("Fisierul nu exista");
    }

    public void adaugaPacient(String nume,String cod){
        pacient=new Pacient(nume, cod);
        if (ts.contains(pacient)) {
            JOptionPane.showMessageDialog(null, "Pacientul exista deja in fisier.", "Alert",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ts.add(pacient);
        JOptionPane.showMessageDialog(null, "A fost adaugata un nou pacient.", "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void salveazaP(){
        try{
            PrintStream ps = new PrintStream("pacienti.txt");
            System.setOut(ps);
            for(Pacient f: ts) ps.println(f.toString());
            ps.close();
        }catch(IOException e){e.printStackTrace();}
    }

    public void stergePacient(String nume){
        Iterator<Pacient> it=ts.iterator();
        while (it.hasNext()){
            if(nume.equalsIgnoreCase(it.next().getNp())) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Pacientul a fost sters din colectia fisier", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Pacientul nu se gaseste in fisier", "Alert", JOptionPane.ERROR_MESSAGE);
    }

    public static ColectiePacienti getInstanta(){ if (instanta==null) instanta=new ColectiePacienti();
        return instanta;
    }
}
