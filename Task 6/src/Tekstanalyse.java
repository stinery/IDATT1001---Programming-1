public class Tekstanalyse {
    private String tekst;
    private String orginal;
    private int[] antallTegn = new int[30];

    public Tekstanalyse(String tekst){
        this.orginal = tekst;
        this.tekst = tekst.toLowerCase();

    }

    public void setTekst(String tekst) {
        tekst = tekst.toLowerCase();
        orginal = tekst;

    }

    public String getOrginal() {
        return orginal;

    }

    public void leggTil(){
        for(int i = 0; i < tekst.length(); i++){
            char verdi = tekst.charAt(i);

            int plass;
            if(verdi>=97 && verdi<=122) {
                plass = verdi - 97;
            }
            else if(verdi == 230) { // æ
                plass = 26;

            }
            else if (verdi == 248) {// ø
                plass = 27;

            }
            else if(verdi == 229){// å
                plass = 28;
            }
        }
    }

    public int antallUlike(){
        int antall = 0;

        for(int i = 0; i < antallTegn.length-1; i++) {
            if (antallTegn[i] > 0) {
                antall++;
            }
        }

        return antall;
    }

    public int antallBokstaver(){
        int antall = 0;

        for(int i = 0; i < antallTegn.length-1; i++){
            antall +=antallTegn[i];
        }

        return antall;
    }

    public double erIkkeBokstaver(){
        double bokstav = antallBokstaver();
        double ikkeBokstav = antallTegn[29];

        double prosent = ikkeBokstav/(bokstav+ikkeBokstav)*100;

        return prosent;
    }

    public int antallGanger(String b){

        if (b.length() == 1){

            char verdi = b.charAt(0);

            int plass;
            if(verdi>=97 && verdi<=122) {
                plass = verdi - 97;
            }
            else if(verdi == 230) { // æ
                plass = 26;

            }
            else if (verdi == 248) {// ø
                plass = 27;

            }
            else if(verdi == 229){// å
                plass = 28;

            } else throw new IllegalArgumentException("Error: Velg en bokstav");

            return antallTegn[plass];

        }else throw new IllegalArgumentException("Error: Skriv inn kun en bokstav");

    }
    public String tilChar(int x) {
        String c = "";
        if (x >= 0 && x <= 25) {
            c += (char) (x + 97);
        } else if (x == 26) {
            c += "æ";
        } else if (x == 27) {
            c += "ø";
        } else if (x == 28) {
            c += "å";
        } else {
            c += "symbol(er)";
        }
        return c;
    }

    public void flest(){
        String bokstav = "";
        int antall = 0;
        for (int i=0; i<antallTegn.length-1; i++){
            if (antallTegn[i]>antall){
                antall = antallTegn[i];
                bokstav = tilChar(i);
            }
            else if(antallTegn[i]==antall){
                bokstav += tilChar(i);
            }
        }
    }
}


