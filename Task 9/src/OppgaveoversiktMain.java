import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Oppgaveoversikt{
    private Student[] studenter;
    private int antStud = 0;

    public Oppgaveoversikt() {
        this.studenter = new Student[0];
    }

    public int getAntStud(){
        return antStud;
    }

    public int getAntOppg(int x){
        return studenter[x].getAntOppg();
    }

    private void utvidTabell(){
        Student[] nyTabell = Arrays.copyOf(studenter, studenter.length + 1);
        studenter = nyTabell;
    }

    public boolean regNyStud(String navn, int antOppg){
        if(antStud == studenter.length){
            utvidTabell();
        }
        studenter[antStud] = new Student(navn, antOppg);
        antStud++;
        return true;
    }
    public void okAntOppg(int x, int okning){
        studenter[x].okAntOppg(okning);

    }

    public String toString2(int x){
        return studenter[x].toString();
    }

    public String toString(){
       String alleStudenten = "";
       for (int i = 0; i < antStud; i++) {
           alleStudenten += studenter[i].toString() + "\n";
       }
       return alleStudenten;
    }
}

public class OppgaveoversiktMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Oppgaveoversikt minKlasse = new Oppgaveoversikt();
        int valg = 0;

        while(valg != 5){
            System.out.println("\n1.Registrer ny student\n2.Se alle studentene\n3.Se antall oppgaver løst hos en bestemt student\n4.Øke/minske antall oppgaver hos en bestemt student\n5.Avslutt\n");
            valg = in.nextInt();
            switch(valg){
                case 1:
                    System.out.println("Navn og antall godkjente oppgaver:");
                    minKlasse.regNyStud(in.next(), in.nextInt());
                    break;

                case 2:
                    System.out.println(minKlasse.toString());
                    break;

                case 3:
                    System.out.println("Hvem vil du se?");
                    int pers = in.nextInt();
                    System.out.println("\n" + minKlasse.toString2(pers));
                    break;

                case 4:
                    System.out.println("\nHvem vil du øke/minske oppgaver hos?\n");
                    int dude = in.nextInt();
                    System.out.println("\n" + minKlasse.toString2(dude) + "\n\nHvor mye vil du øke/minske?\n");
                    int ook = in.nextInt();
                    minKlasse.okAntOppg(dude, ook);
                    System.out.println(minKlasse.toString2(dude));
                    break;
            }
        }
        System.out.println("\nProgram avsluttet.");
    }
}
