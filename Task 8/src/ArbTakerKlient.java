import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;

class Person {
    private final String fornavn;
    private final String etternavn;
    private final int fodselsar;

    public Person(String fornavn, String etternavn, int fodselsar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsar = fodselsar;
    }

    public String getFornavn(){
        return fornavn;
    }

    public String getEtternavn(){
        return etternavn;
    }

    public int getFodselsar(){
        return fodselsar;
    }
}

class ArbTaker{
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesar;
    private double manedslonn;
    private double skatteprosent;

    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesar,double manedslonn, double skatteprosent){
        String fornavn = personalia.getFornavn();
        String etternavn = personalia.getEtternavn();
        int fodselsar = personalia.getFodselsar();
        this.personalia = new Person(fornavn, etternavn, fodselsar);
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;
        this.skatteprosent = skatteprosent;
    }

    public Person getPersonalia(){
        return new Person(personalia.getFornavn(), personalia.getEtternavn(), personalia.getFodselsar());
    }

    public int getArbtakernr(){
        return arbtakernr;
    }

    public void setArbtakernr(int arbtakernr){
        this.arbtakernr = arbtakernr;
    }

    public int getAnsettelsesar(){
        return ansettelsesar;
    }

    public void setAnsettelsesar(int ansettelsesar){
        this.ansettelsesar = ansettelsesar;
    }

    public double getManedslonn(){
        return manedslonn;
    }

    public void setManedslonn(double manedslonn){
        this.manedslonn = manedslonn;
    }

    public double getSkatteprosent(){
        return skatteprosent;
    }

    public void setSkatteprosent(double skatteprosent){
        this.skatteprosent = skatteprosent;
    }

    public double trektISkatt(){
        return manedslonn * skatteprosent/100;
    }

    public double lonnPerAr(){
        return manedslonn * 12;
    }

    public double skattetrekkPerAr(){
        return trektISkatt() * 10.5;
    }

    public String navn(){
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }

    public int alder(){
        int ar = Year.now().getValue();
        return ar - personalia.getFodselsar();
    }

    public int arIBedriften(){
        int ar = Year.now().getValue();
        return ar - ansettelsesar;
    }

    public boolean ansattEnnMer(int x){
        int ar = Year.now().getValue();

        return arIBedriften() > x;
    }

    public String toString(int v, int x) {
        if (v == 1) {
            return "1.Arbeidstaker nr: " + arbtakernr + "\n2.Ansettelsesår: " + ansettelsesar + "\n3.Månedslønn: " + manedslonn + "\n4.Skatteprosent: " + skatteprosent + "%" + "\n5.År ansatt mer enn: " + x + "år";
        }
        return "----------------------\nAnsatt informasjon\n----------------------\nArbeidstaker nr: " + arbtakernr + "\nNavn: " + navn() + "\nAlder: " + alder() + "år" + "\nAnsettelsesår: " + ansettelsesar + "\nMånedslønn: " + manedslonn + "\nSkatteprosent: " + skatteprosent + "%" + "\n----------------------\nBrutto årslønn: " + lonnPerAr() +  "\nSkattetrekk per mnd: " + trektISkatt() + "\nSkattetrekk per år: " + skattetrekkPerAr() + "\nAntall år i bedriften: " + arIBedriften() + "år\nAnsatt i mer enn " + x + "år: " + ansattEnnMer(x) + "\n----------------------";
    }
}

public class ArbTakerKlient {
    public static void main(String[] args) {
        Person navn1 = new Person("Stine", "Rygh", 1994);
        ArbTaker p1 = new ArbTaker(navn1, 1234, 2010, 20000, 7.0);
        Scanner in = new Scanner(System.in);
        int x = 5;

        while(1<2){
            System.out.println("\n" + p1.toString(0, x) + "\n");
            System.out.println("\nVil du..\n1.Endre ansatt info\n2.Avslutt\n");
            int valg = in.nextInt();

            if(valg == 1){
                System.out.println("\nHva vil du endre?\n" + p1.toString(valg,x) + "\n");
                int aams = in.nextInt();

                if(aams == 1){
                    System.out.println("\nHva er det nye arbeidstaker nummeret?");
                    p1.setArbtakernr(in.nextInt());
                }
                else if(aams == 2){
                    System.out.println("\nHva er det nye ansettelsesåret?\n");
                    p1.setAnsettelsesar(in.nextInt());
                }
                else if(aams == 3){
                    System.out.println("\nHva er den nye månedslønnen?\n");
                    p1.setManedslonn(in.nextDouble());
                }
                else if(aams == 4){
                    System.out.println("\nHva er den nye skatteprosenten?\n");
                    p1.setSkatteprosent(in.nextDouble());
                }
                else if(aams == 5){
                    System.out.println("\nHvor mange år vil du sjekke med?\n");
                    x = in.nextInt();
                }
            }

            if(valg == 2){
                System.out.println("Program avsluttet.");
                break;
            }
        }
    }
}
