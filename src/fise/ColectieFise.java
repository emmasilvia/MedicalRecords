package fise;

import buletin.Buletin;
import buletin.ColectieBuletine;
import cerere.Cerere;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ColectieFise {

    private TreeSet<FisaMedicala> ts;
    private BufferedReader br;
    private PrintWriter pw;
    private String l;
    private static ColectieFise cf;
    private FisaMedicala fisaMedicala;

    private ColectieFise() {
        File f = new File("fise.txt");
        ts = new TreeSet<>();
        FisaMedicala fisa = null;

        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));
                while ((l = br.readLine()) != null) {
                    String[] s = l.split("_");
                    String[] s1 = s[0].split(" ");
                    fisa = new FisaMedicala(s1[0], s1[1], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8],s[9]);
                    ts.add(fisa);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Fisierul nu exista");
    }

    public String getFise(){
        StringBuffer rez=new StringBuffer();
        Iterator<FisaMedicala> it=ts.iterator();
        while (it.hasNext()) rez.append(it.next().toString()+"\n");
        return rez.toString();
    }

    public void stergeFise(String nume){
        Iterator<FisaMedicala> it=ts.iterator();
        while (it.hasNext()){
            if(nume.equalsIgnoreCase(it.next().getNume())) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Fisa a fost stearsa din colectie", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Fisa nu se gaseste in colectie", "Alert", JOptionPane.ERROR_MESSAGE);
    }

    public String cautaFisa(String cnp){
        for(FisaMedicala f: ts) if(cnp.equals(f.getCnp())) return f.toString();
        return "nu exista nicio fisa cu numele "+ cnp;
    }

    public void salveazaF(){
        try{
            pw=new PrintWriter(new FileWriter("fise.txt"));
            for(FisaMedicala f:ts) pw.println(f);
            pw.close();
        }catch(IOException e){e.printStackTrace();}
    }

    public void adaugaFisa(String nume, String prenume, String datan, String cnp, String varsta, String sex, String adresa, String datar, String rez1, String rez2,String tr){
        fisaMedicala=new FisaMedicala(nume, prenume, datan, cnp, varsta, sex, adresa, datar, rez1, rez2,tr);
        if (ts.contains(fisaMedicala)) {
            JOptionPane.showMessageDialog(null, "Fisa exista deja in colectie", "Alert",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ts.add(fisaMedicala);
        JOptionPane.showMessageDialog(null, "A fost adaugat o fisa noua", "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static ColectieFise getInstanta(){
        if(cf == null) cf=new ColectieFise();
        return cf;
    }
}
