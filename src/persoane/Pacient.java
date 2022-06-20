package persoane;

public class Pacient implements Comparable<Pacient>{

    private String np, cod;

    public Pacient(String np, String cod) {
        this.np = np;
        this.cod = cod;
    }

    public String getNp(){
        return np;
    }

    public String toString() {
        return np+ ","+ cod;
    }

    @Override
    public int compareTo(Pacient p) {
        return np.compareTo(p.getNp());
    }
}
