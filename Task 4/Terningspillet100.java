class Spiller{
	private String navn;
	private int sumPoeng;
	java.util.Random terning = new java.util.Random();

	public Spiller(String navn, int sumPoeng){
		this.navn = navn;
		this.sumPoeng = sumPoeng;
	}
	public int getSumPoeng(){
		return sumPoeng;
	}
	public void kastTerningen(){
		int terningkast = terning.nextInt(6)+1;

		if(sumPoeng < 100){
			sumPoeng += terningkast;
		}
		else {
			sumPoeng -= terningkast;
		}
		if(terningkast == 1){
			sumPoeng = 0;

		}
	}
	public boolean erFerdig(){
		return sumPoeng == 100;
	}
}

class Terningspillet100{
	public static void main(String[] args){
		Spiller a = new Spiller("A", 0);
		Spiller b = new Spiller("B", 0);

		int runder = 1;

		while(a.erFerdig() == false && b.erFerdig() == false){
			System.out.println("---------------\nRunde nr: " + runder + "\n");
			a.kastTerningen();
			System.out.println("Spiller A: " + a.getSumPoeng());
			b.kastTerningen();
			System.out.println("Spiller B: " + b.getSumPoeng() + "\n");

			runder++;
		}
		if(a.erFerdig()){
			System.out.println("---------------\nSPILLER A VANT!\n---------------\n");
		} else {
			System.out.println("---------------\nSPILLER B VANT!\n---------------\n");
		}
	}
}