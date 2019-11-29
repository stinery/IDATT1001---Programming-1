import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Rett{
    private String navn;
    private String type;
    private int pris;
    private String oppskrift;

    public Rett(String navn, String type, int pris, String oppskrift){
        this.navn = navn.toLowerCase();
        this.type = type.toLowerCase();
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public int getPris() {
        return pris;
    }

    public String toString() {
        return "\n-------------------\n" + navn + "      " + pris + " kr\n\nOppskrift: \n" + oppskrift;
    }
}

class Meny {
    private ArrayList<Rett> meny;
    private String restaurantNavn;


    public Meny(String restaurantNavn, ArrayList<Rett> retter) {
        this.restaurantNavn = restaurantNavn;
        this.meny = retter;
    }

    public int pris() {
        int pris = 0;

        for (int i = 0; i < meny.size(); i++) {
            pris += meny.get(i).getPris();
        }
        return pris;
    }

    public String toString (){
        String menyMedRetter =  "\n-------------------\n\n" + restaurantNavn + "\n";
        for (Rett retter: meny) {
            menyMedRetter += retter.toString();
        }
        return menyMedRetter + "\n-------------------";
    }
}

class MenyRegister {
    private ArrayList<Meny> menyRegister = new ArrayList<>();
    public ArrayList<Rett> rettRegister = new ArrayList<>();

    public boolean registrerNyRett(String navn, String type, int pris, String oppskrift) {
        rettRegister.add(new Rett(navn, type, pris, oppskrift));
        return true;
    }

    public String finnEnRettEtterNavn(String navn) {
        String rettenEtterNavn = "";
        for (int i = 0; i < rettRegister.size(); i++) { //Looper gjennom alle retteme
            if (navn.toLowerCase().equals(rettRegister.get(i).getNavn())) { //Dersom navnet er likt som et navn i registeret
                rettenEtterNavn += rettRegister.get(i) + "\n";
            }
        }
        return rettenEtterNavn;
    }

    public String finnAlleRetterEtterGittType(String type) {
        String retteneEtterType = "";
        for (int i = 0; i < rettRegister.size(); i++) {
            if (type.toLowerCase().equals(rettRegister.get(i).getType())) {
                retteneEtterType += rettRegister.get(i) + "\n";
            }
        }
        return retteneEtterType;
    }

    public void nyMenyMedRetter(String restaurantnavn, ArrayList<Rett> meny){
        menyRegister.add(new Meny(restaurantnavn, meny));
    }

    public String prisIntervall(int pris1, int pris2){
        String prisIntervall = "";
        for(int i = 0; i < menyRegister.size(); i++){
            if(menyRegister.get(i).pris() >= pris1 && menyRegister.get(i).pris() <= pris2) {
                prisIntervall += menyRegister.get(i).toString();
            }
        }
        return prisIntervall;
    }

    public String toString() {
        String alleMenyene = "";
        for (int i = 0; i < menyRegister.size(); i++) {
            alleMenyene += menyRegister.get(i).toString() + "\n";
        }
        return alleMenyene;
    }

    public String toString2(){
        String alleRettene = "";
        for(int i = 0; i < rettRegister.size(); i ++){
            alleRettene += "\n" + (i+1) + ". " + rettRegister.get(i).toString() + "\n";
        }
        return alleRettene;
    }
}

public class MenyRegisterKlient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MenyRegister menyRegisterNr1 = new MenyRegister();
        ArrayList<Rett> meny1 = new ArrayList<>();
        int valg = 0;
        menyRegisterNr1.registrerNyRett("Margarita", "Hovedrett", 135, "Mel, gjær og vann");
        menyRegisterNr1.registrerNyRett("Pasta Carbonara", "Hovedrett", 175, "Bacon, egg og løk");
        menyRegisterNr1.registrerNyRett("Sjokolade Fondant", "Dessert", 90, "Sjokolade og melis");
        menyRegisterNr1.registrerNyRett("Tomatsuppe", "Forrett", 110, "Tomat og basilikum");

        while (valg != 6) {
            System.out.println("\n1.Registrere en ny rett\n2.Finne en rett etter navnet\n3.Finne en rett etter typen\n4.Registrere en meny med retter\n5.Finne en menyer mellom et prisintervall\n6.Avslutt\n");
            valg = in.nextInt();
            switch (valg) {
                case 1:
                    System.out.println("Navn, type, pris og oppskrift:\n");
                    menyRegisterNr1.registrerNyRett(in.next() + in.nextLine(), in.next() + in.nextLine(), in.nextInt(), in.next() + in.nextLine());
                    break;

                case 2:
                    System.out.println("Navnet på retten:\n");
                    System.out.println(menyRegisterNr1.finnEnRettEtterNavn(in.next() + in.nextLine()));
                    break;

                case 3:
                    System.out.println("Hvilken type retter vil du se:\n");
                    System.out.println(menyRegisterNr1.finnAlleRetterEtterGittType(in.next() + in.nextLine()));
                    break;

                case 4:
                    System.out.println("Skriv navnet på restauranten/menyen:\n");
                    menyRegisterNr1.nyMenyMedRetter(in.next() + in.nextLine(), meny1);
                    System.out.println("\nHvor mange retter vil du legge til i menyen?\n");
                    int antRetter = in.nextInt();
                    System.out.println(menyRegisterNr1.toString2() + "\nSkriv inn tall på rettene du vil legge til:");

                    for (int i = 0; i < antRetter; i++) {
                        meny1.add(menyRegisterNr1.rettRegister.get(in.nextInt() - 1));
                    }
                    System.out.println(menyRegisterNr1.toString());
                    break;

                case 5:
                    System.out.println("Skriv inn startpris og sluttpris:\n");
                    System.out.println(menyRegisterNr1.prisIntervall(in.nextInt(), in.nextInt()));
                    break;
            }
        }
        System.out.println("Program avsluttet.");
    }
}

