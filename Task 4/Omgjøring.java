import static javax.swing.JOptionPane.*;

class Valuta{
	private String valuta;
	private double kurs;

	public Valuta(String valuta, double kurs){ //Konstruktør
		this.valuta = valuta;
		this.kurs = kurs;
	}
	public String getValuta(){
		return valuta;
	}
	public double fra(int belop){ //Regner fra NOK
		return belop/kurs;
	}
	public double til(int belop){ //Regner til NOK
		return belop * kurs;
	}
}

class Omgjøring{
	public static void main(String[] args){
		while(1<2){

			//Velger fra eller til norske kroner
			String ftLest = showInputDialog("Velg handling: \n 1. Fra NOK \n 2. Til NOK \n 3.Avslutt");
			int ft = Integer.parseInt(ftLest);
			if(ft == 3){
				System.out.println("Program avsluttet.");
				break;
			}
			else if(ft > 3){
				System.out.println("Ikke gyldig handling..");
				break;
			}

			//Velger valuta
			String valutaLest = showInputDialog("Velg valuta: \n 1. Dollar \n 2. Euro \n 3. Svenske kroner");
			int valuta = Integer.parseInt(valutaLest);
			if(valuta > 3){
				System.out.println("Ikke gyldig valuta.");
				break;
			}

			// Skriver inn beløpet
			String belopLest = showInputDialog("Fyll inn beløp: ");
			int belop = Integer.parseInt(belopLest);
			if(belop <= 0){
				System.out.println("Ikke gyldig beløp.");
				break;
			}

			//Valuta navn og kurs
			Valuta d = new Valuta(" dollar", 9.06);
			Valuta e = new Valuta(" euro", 10.04);
			Valuta sk = new Valuta(" svenske kroner", 0.93);

			if (valuta == 1){
				if (ft == 1){
					System.out.printf(belop + " norske kroner er lik %1.2f" + d.getValuta() + "\n", d.fra(belop));
				}
				else if (ft == 2){
					System.out.printf(belop + d.getValuta() + " er lik %1.2f i norske kroner." + "\n", d.til(belop));
				}
			}
			else if(valuta == 2){
				if (ft == 1){
					System.out.printf(belop + " norske kroner er lik %1.2f" + e.getValuta() + "\n", e.fra(belop));
				}
				else if (ft == 2){
					System.out.printf(belop + e.getValuta() + " er lik %1.2f i norske kroner." + "\n", e.til(belop));
				}
			}
			else if(valuta == 2){
				if (ft == 1){
					System.out.printf(belop + " norske kroner er lik %1.2f" + e.getValuta() + "\n", e.fra(belop));
				}
				else if (ft == 2){
					System.out.printf(belop + e.getValuta() + " er lik %1.2f i norske kroner." + "\n", e.til(belop));
				}
			}
			else if(valuta == 3){
				if (ft == 1){
					System.out.printf(belop + " norske kroner er lik %1.2f" + sk.getValuta() + "\n", sk.fra(belop));
				}
				else if (ft == 2){
					System.out.printf(belop + sk.getValuta() + " er lik %1.2f i norske kroner." + "\n", sk.til(belop));
				}
			}
		}
	}
}