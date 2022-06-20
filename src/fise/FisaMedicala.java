package fise;


public class FisaMedicala implements Comparable<FisaMedicala> {

    private String nume, prenume, adresa,datan,cnp,varsta,sex ,datar,rez1, rez2,tr;

    public FisaMedicala(String nume, String prenume,String dataNastere , String CNP,String varsta, String sex,String adresa ,String datar,String rez1,String rez2,String tr){
        this.nume=nume;
        this.prenume = prenume;
        this.datan=dataNastere;
        this.cnp=CNP;
        this.varsta=varsta;
        this.sex=sex;
        this.adresa=adresa;
        this.datar=datar;
        this.rez1=rez1;
        this.rez2=rez2;
        this.tr=tr;
    }

    public String getNume(){
        return nume + " " + prenume;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return nume + ' ' + prenume + '_' + datan + '_' + cnp + '_' + varsta+ '_' + sex +"_"+adresa+ '_' + datar + "_" + rez1 + '_' + rez2 + "_" + tr ;
    }

    @Override
    public int compareTo(FisaMedicala f) {
        return (nume+" "+prenume).compareTo(f.getNume());
    }

}
