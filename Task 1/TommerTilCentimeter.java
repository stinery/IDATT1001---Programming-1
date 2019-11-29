import java.util.Scanner;

class TommerTilCentimeter {
	public static void main(String[] args) {

		final double KONSTANT = 2.54;

		Scanner in = new Scanner(System.in);
		System.out.println("Tommer");
		double tommer = in.nextDouble();
		double centimeter = tommer/KONSTANT;
		System.out.printf(tommer + " tommer er ca. %8.2f centimeter.", centimeter);
	}
}