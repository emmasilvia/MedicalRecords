package cerere;

public class Cerere implements Comparable<Cerere>{

    private String nume, prenume, adresa, CNP, dataNastere, sex;

    public Cerere(String nume, String prenume, String adresa, String CNP, String dataNastere, String sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.CNP = CNP;
        this.dataNastere = dataNastere;
        this.sex = sex;
    }

    public String getNume(){
        return nume+ " " + prenume;
    }

    public String toString(){
        return nume+ " "+prenume+"_"+adresa+"_"+CNP+"_"+dataNastere+"_"+sex;
    }

    @Override
    public int compareTo(Cerere c) {
        return (nume+" "+prenume).compareTo(c.getNume());
    }
}
