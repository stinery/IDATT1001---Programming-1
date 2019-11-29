import static javax.swing.JOptionPane.*;

class Brok{
	private int teller;
	private int nevner;

	public Brok(int teller, int nevner){ //Konstruktør1
		this.teller = teller;

		if(nevner != 0){
			this.nevner = nevner;
		} else{
			throw new IllegalArgumentException("Grenseverdi eksisterer ikke");
		}
	}

	public Brok(int teller){ //Konstruktør2
		this.teller = teller;
		this.nevner = 1;
	}

	public int getTeller(){
		return teller;
	}

	public int getNevner(){
		return nevner;
	}

	public void summere(Brok b){
		teller = teller * b.getNevner() + b.getTeller() * nevner;
		nevner = nevner * b.getNevner();
	}

	public void subtrahere(Brok b){
		teller = teller * b.getNevner() - b.getTeller() * nevner;
		nevner = nevner * b.getNevner();
	}

	public void multiplisere(Brok b){
		teller = teller * b.getTeller();
		nevner = nevner * b.getNevner();
	}

	public void dividere(Brok b){
		teller = teller * b.getNevner();
		nevner = nevner *  b.getTeller();
	}
	  public void forkort(){
	    for( int i = 2; i <= nevner; i++){

	        while(teller % i == 0 && nevner % i == 0){
	           teller /= i;
          	   nevner /= i;
			}
		    break;
		}
	}
	public String toString(){
		return "Teller: " + teller + "\nNevner: " + nevner;
	}
}


//Klientprogram
class Brokregning{
	public static void main(String[] args){
		String tellerLest = showInputDialog("Teller: ");
		int teller = Integer.parseInt(tellerLest);
		String nevnerLest = showInputDialog("Nevner: ");
		int nevner= Integer.parseInt(nevnerLest);

		Brok brok1 = new Brok(teller, nevner);

		String teller2Lest = showInputDialog("Teller 1: ");
		int teller2 = Integer.parseInt(teller2Lest);
		String nevner2Lest = showInputDialog("Nevner 2: ");
		int nevner2= Integer.parseInt(nevner2Lest);

		Brok brok2 = new Brok(teller2, nevner2);

		String ssmdLest = showInputDialog("Velg regnemåte:\n 1.Summere\n 2.Subtrahere\n 3.Multiplisere\n 4.Dividere\n 5.Avslutte");
		int ssmd = Integer.parseInt(ssmdLest);

		if (ssmd < 1 || ssmd > 5){
			System.out.println("Ikke gyldig regnemåte.");
		}
		else if(ssmd == 1){
			brok1.summere(brok2);
			brok1.forkort();
			System.out.println(brok1.toString());
		}
		else if(ssmd == 2){
			brok1.subtrahere(brok2);
			brok1.forkort();
			System.out.println(brok1.toString());
		}
		else if(ssmd == 3){
			brok1.multiplisere(brok2);
			brok1.forkort();
			System.out.println(brok1.toString());
		}
		else if(ssmd == 4){
			brok1.dividere(brok2);
			brok1.forkort();
			System.out.println(brok1.toString());
		}
		else if(ssmd == 5){
			System.out.println("Program avsluttet.");
		}
	}
}