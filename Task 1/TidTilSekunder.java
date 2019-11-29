import java.util.Scanner;

class TidTilSekunder {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Timer");
		double timer = in.nextDouble();

		System.out.println("Minutter");
		double minutter = in.nextDouble();

		System.out.println("Sekunder");
		double sekunder = in.nextDouble();

		double totalt = (timer*3600)+(minutter*60)+sekunder;

		System.out.println("Totalt antall sekunder er " + totalt);
	}
}