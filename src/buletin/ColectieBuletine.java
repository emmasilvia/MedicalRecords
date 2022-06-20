package buletin;

import cerere.Cerere;

import javax.swing.*;
import java.io.*;
import java.util.*;


public class ColectieBuletine {

    private TreeSet<Buletin> ts;
    private BufferedReader br;
    private PrintWriter pw;
    private String l;
    private static ColectieBuletine cb;
    private Buletin buletin;

    private ColectieBuletine(){
        File f = new File("buletin.txt");
        ts = new TreeSet<>();
        Buletin b = null;

        if(f.exists()) {
            try {
                br=new BufferedReader(new FileReader(f));
                while ((l=br.readLine())!=null){
                    String[] s = l.split("_");
                    String[] s1 = s[0].split(" ");
                    b = new Buletin(s1[0], s1[1], s[1], s[2], s[3], s[4],s[5],s[6],s[7],s[8]);
                    ts.add(b);
                }
            }catch (IOException e){e.printStackTrace();}
        }
    }

    public void adaugaBuletin(String nume, String prenume, String datan, String cnp, String varsta, String sex, String adresa, String datar, String rez1, String rez2){
        buletin=new Buletin(nume, prenume, datan, cnp, varsta, sex, adresa, datar, rez1, rez2);
        if (ts.contains(buletin)) {
            JOptionPane.showMessageDialog(null, "Buletinul exista deja in colectie", "Alert",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ts.add(buletin);
        JOptionPane.showMessageDialog(null, "A fost adaugat un buletin nou", "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void salveazaB(){
        try{
            pw=new PrintWriter(new FileWriter("buletin.txt"));
            for(Buletin b:ts) pw.println(b);
            pw.close();
        }catch(IOException e){e.printStackTrace();}
    }

    public String getBuletine(){
        StringBuffer rez=new StringBuffer();
        Iterator<Buletin> it=ts.iterator();
        while (it.hasNext()) rez.append(it.next().toString()+"\n");
        return rez.toString();
    }

    public static ColectieBuletine getInstanta(){
        if(cb == null) cb=new ColectieBuletine();
        return cb;
    }
}
