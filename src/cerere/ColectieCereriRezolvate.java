package cerere;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ColectieCereriRezolvate {

    private TreeSet<Cerere> ts;
    private BufferedReader br;
    private String l;
    private Cerere cerere;

    private static ColectieCereriRezolvate instanta;


    private ColectieCereriRezolvate() {
        File f = new File("cereriRezolvate.txt");
        ts = new TreeSet<>();
        String[] s, s1;
        String a;
        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));
                while ((l = br.readLine()) != null) {
                    s = l.split("_");
                    s1 = s[0].split(" ");
                    a = s[4];
                    if (s.length > 5) a += "_" + s[4];
                    cerere = new Cerere(s1[0], s1[1], s[1], s[2], s[3], a);
                    ts.add(cerere);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else System.out.println("Fisierul nu exista");
    }

    public String getCereriRezolvate(){
        StringBuffer rez=new StringBuffer();
        Iterator<Cerere> it=ts.iterator();
        while (it.hasNext()) rez.append(it.next().toString()+"\n");
        return rez.toString();
    }

    public static ColectieCereriRezolvate getInstanta(){ if (instanta==null) instanta=new ColectieCereriRezolvate();
        return instanta;
    }
}
