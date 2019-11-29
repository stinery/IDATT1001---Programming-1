
class Student {
    private final String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void okAntOppg(int okning){
        antOppg = antOppg + okning;

    }
    public String toString(){
        return "Studentens navn: " + navn + "\nAntall godkjente oppgaver: " + antOppg + "\n";
    }
}

public class StudentMain{
    public static void main(String[] args) {
        Student s1 = new Student("Bente Lind", 0);
        System.out.println(s1.toString());
        s1.okAntOppg(4);
        System.out.println(s1.toString());
    }
}


