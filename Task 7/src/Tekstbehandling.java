import java.util.regex.Pattern;

class Behandling {
    private String tekst;

    public Behandling(String tekst){
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public int antallOrd(){
        String[] ord = tekst.split(" ");
        return ord.length;
    }

    public int gjennomsnittligOrd(){
        String[] ord = tekst.split("[!,. ]+");
        int bokstaver = 0;
        for(int i = 0; i < ord.length; i++) {
            bokstaver += ord[i].length();
        }
        return bokstaver/ord.length;
    }

    public int ordPerPeriode(){
        String[] ord = tekst.split("[!,.]+");
        return antallOrd()/ord.length;
    }

    public String replaceAll(String f,String s){
        return Pattern.compile(f).matcher(this.tekst).replaceAll(s);
    }

    public String toUpperCase(){
        return tekst.toUpperCase();
    }

    public String toString(String f,String s){
        return "Antall ord i teksten: " + antallOrd() + "\n" + "Gjennomsnittlig ordlengde: " + gjennomsnittligOrd() + "\n" + "Gjennomsnittlig antall ord per periode: " + ordPerPeriode() + "\n" + replaceAll(f,s) + "\n" + getTekst() + "\n" + toUpperCase();
    }
}

public class Tekstbehandling {
    public static void main(String[] args) {
        Behandling t1 = new Behandling("Jeg heter Stine og er 25år gammel.");
        System.out.println(t1.toString("25år","13år"));
    }
}
