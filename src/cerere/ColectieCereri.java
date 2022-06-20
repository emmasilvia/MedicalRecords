package cerere;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ColectieCereri {

    private TreeSet<Cerere> ts;
    private BufferedReader br;
    private String l;
    private Cerere cerere;

    private static ColectieCereri instanta;

    private ColectieCereri(){
        File f = new File("cereri.txt");
        ts = new TreeSet<>();
        String[] s,s1;
        String a;
        if (f.exists()){
            try{
                br=new BufferedReader(new FileReader(f));
                while ((l=br.readLine())!=null){
                    s=l.split("_");
                    s1=s[0].split(" ");
                    a=s[4];
                    if(s.length>5) a+="_"+s[4];
                    cerere=new Cerere(s1[0], s1[1], s[1], s[2], s[3], a);
                    ts.add(cerere);
                }
            }catch(IOException ioe){ioe.printStackTrace();}
        } else System.out.println("Fisierul nu exista");
    }

    public void adaugaCerere(String nume, String prenume, String adresa, String datan, String cnp, String sex){
        cerere=new Cerere(nume, prenume, adresa, datan, cnp, sex);
        if (ts.contains(cerere)) {
            JOptionPane.showMessageDialog(null, "Cererea exista deja in colectie", "Alert",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ts.add(cerere);
        JOptionPane.showMessageDialog(null, "A fost adaugata o noua cerere", "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }



    public String cautaCerere(String nume){
        for(Cerere f: ts) if(nume.equals(f.getNume())) return f.toString();
        return "nu exista nicio fisa cu numele "+ nume;
    }

    public void salveaza(){
        try{
            PrintStream ps = new PrintStream("cereri.txt");
            System.setOut(ps);
            for(Cerere f: ts) ps.println(f.toString());
            ps.close();
        }catch(IOException e){e.printStackTrace();}
    }

    public String salveazaCerereRezolvata(String nume){
        try{
            FileWriter ps = new FileWriter("cereriRezolvate.txt", true);

            for(Cerere f: ts) if(nume.equals(f.getNume()))
                ps.append(f.toString() + "\n");
            ps.flush();
            ps.close();
        }catch(IOException e){e.printStackTrace();}
        return "nu exista";
    }

    public String getCereri(){
        StringBuffer rez=new StringBuffer();
        Iterator<Cerere> it=ts.iterator();
        while (it.hasNext()) rez.append(it.next().toString()+"\n");
        return rez.toString();
    }


    public void stergeCerere(String nume){
        Iterator<Cerere> it=ts.iterator();
        while (it.hasNext()){
            if(nume.equalsIgnoreCase(it.next().getNume())) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Cererea a fost stearsa din colectia de cereri", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cererea nu se gaseste in colectia de cereri", "Alert", JOptionPane.ERROR_MESSAGE);
    }

    public static ColectieCereri getInstanta(){ if (instanta==null) instanta=new ColectieCereri();
        return instanta;
    }
}