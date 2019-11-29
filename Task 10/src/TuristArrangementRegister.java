import java.util.*;

class Arrangement {
    private int nummer;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private long tidspunkt;

    public Arrangement(int nummer, String navn, String sted, String arrangor, String type, long tidspunkt){
        this.nummer = nummer;
        this. navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer){
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public String getArrangor() {
        return arrangor;
    }

    public void setArrangor(String arrangor) {
        this.arrangor = arrangor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(long tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getKlokkeslett(){
        return String.valueOf(getTidspunkt()).substring(8,12);
    }

    public String toString() {
        return "\nNummer: " + nummer +
                "\nNavn: "+ navn +
                "\nSted: " + sted +
                "\nArrangør: " + arrangor +
                "\nType: " + type +
                "\nTidspunkt: kl." + String.valueOf(getTidspunkt()).substring(8,10) + ":" +
                String.valueOf(getTidspunkt()).substring(10,12) + "  Dato: " +
                String.valueOf(getTidspunkt()).substring(6,8) + "." +
                String.valueOf(getTidspunkt()).substring(4,6) + "." +
                String.valueOf(getTidspunkt()).substring(0,4);
    }
}

class ArrangementRegister{
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public boolean registrerNyttArrangement(int nummer, String navn, String sted, String arrangor, String type, long tidspunkt) {
        arrangementer.add(new Arrangement(nummer, navn, sted, arrangor, type, tidspunkt));
        return true;
    }

    public int tabellLengde() {
        return arrangementer.size() + 1;
    }

    public void sorterListe(int x){
        if(x == 1){
            arrangementer.sort(Comparator.comparing(Arrangement::getSted));
        }
        else if(x == 2){
            arrangementer.sort(Comparator.comparing(Arrangement::getType));
        }
        else{
            arrangementer.sort(Comparator.comparing(Arrangement::getTidspunkt));
        }

    }

    public String sted(String stedet) {
        String liste = "";
        for (int i = 0; i < arrangementer.size(); i++) {
            if (Objects.equals(arrangementer.get(i).getSted().trim().toLowerCase(), stedet.trim().toLowerCase())) {
                liste += arrangementer.get(i).getNavn() + "\n";
            }
        }
        return liste;
    }
    public String dato(long datoen) {
        String liste = "";
        for (int i = 0; i < arrangementer.size(); i++) {
            if (Objects.equals(Long.parseLong(Long.toString(arrangementer.get(i).getTidspunkt()).substring(0, 8)), datoen)){
                liste += arrangementer.get(i).getNavn() + "\n";
            }
        }
        return liste;

    }
    public String tidsintervall(long fra, long til) {
        String liste = "";
        for (int i = 0; i < arrangementer.size(); i++) {
            long dato = Long.parseLong(Long.toString(arrangementer.get(i).getTidspunkt()).substring(0, 8));
            if (dato >= fra && dato <= til) {
                liste += arrangementer.get(i).getKlokkeslett() + "\n";
                arrangementer.sort(Comparator.comparing(Arrangement::getKlokkeslett));
            }
            else{
                System.out.println("\nDet er ikke registrert noen arrangementer i dette tidsintervallet.");
            }
        }
        return liste;
    }

    public String toString(){
        String alleArrangement = "";
        for (int i = 0; i < arrangementer.size(); i++) {
            alleArrangement += arrangementer.get(i).toString() + "\n";
        }
        if (alleArrangement.equals("")){
            return "\nDet er ikke registerert noen arrangementer.";
        }
        else return alleArrangement;
    }
}

public class TuristArrangementRegister{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrangementRegister arrangementListe = new ArrangementRegister();
        int valg = 0;
        arrangementListe.registrerNyttArrangement(1, "Konsert", "Dødens Dal", "UKA", "Konsert", 201912300000L);
        arrangementListe.registrerNyttArrangement(2, "Stines bursdag", "Heimdal", "Privatperson", "Bursdag", 202002151930L);

        while(valg != 7){
            System.out.println("\n1.Se alle arrangement\n2.Registrer nytt arrangement\n3.Finn arrangement på et gitt sted\n4.Finn arrangement på en gitt dato\n5.Sjekke arrangementer innenfor et tidsintervall gitt ved dato\n6.Sorter arrangement\n7.Avslutt\n");
            valg = in.nextInt();
            switch(valg){
                case 1:
                    System.out.println(arrangementListe.toString());
                    break;
                case 2:
                    System.out.println("Skriv inn navn på arrangementet, sted, arrangør, type arrangement og dato(ÅÅÅÅMMDDTTTT).");
                    int nummerLengde = arrangementListe.tabellLengde();
                    in.nextLine();
                    String navn = in.nextLine();
                    String sted = in.nextLine();
                    String arrangor = in.nextLine();
                    String type = in.nextLine();
                    long tidspunkt = in.nextLong();

                    arrangementListe.registrerNyttArrangement(nummerLengde, navn, sted, arrangor, type, tidspunkt);
                    break;

                case 3:
                    System.out.println("Skriv inn et sted: \n");
                    System.out.println("\n" + arrangementListe.sted(in.next() + in.nextLine()));
                    break;

                case 4:
                    System.out.println("Skriv inn en dato(AAAAMMDD): \n");
                    System.out.println("\n" + arrangementListe.dato(in.nextLong()));
                    break;

                case 5:
                    System.out.println("Skriv inn start dato og slutt dato(AAAAMMDD): ");
                    System.out.println("\n" + arrangementListe.tidsintervall(in.nextLong(), in.nextLong()));
                    break;

                case 6:
                    System.out.println("Vil du sortere etter..\n1.Sted\n2.Type\n3.Tidspunkt\n");
                    arrangementListe.sorterListe(in.nextInt());
                    System.out.println("\n" + arrangementListe);
                }
        }
        System.out.println("\nProgram avsluttet.");
    }
}