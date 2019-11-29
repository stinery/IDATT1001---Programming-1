class NyString {
    private final String tekst;

    public NyString(String tekst){
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public String split(){
        String[] ord = tekst.split(" ");
        String splittet = "";
        for(int i = 0; i < ord.length; i++) {
            splittet += ord[i].charAt(0);
        }

        return splittet;
    }

    public String fjernBokstav(String b){
        return tekst.replace(b, "");
    }

    public String toString(String b){
        return split() + "\n" + fjernBokstav(b);
    }
}

public class Bokstavbehandling {
    public static void main(String[] args) {
        NyString s1 = new NyString("Hei jeg går dataingeniør");
        System.out.println(s1.toString("e"));
    }
}
