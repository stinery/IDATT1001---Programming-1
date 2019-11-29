import java.util.Scanner;

class Gangetabell{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Tall 1: ");
		int tall1 = in.nextInt();
		System.out.println("Tall 2: ");
		int tall2 = in.nextInt();

		for (int i = tall1; i <= tall2; i++){
			System.out.println(i + "-gangen:");
			for (int j = 1; j <= 10; j++){
				int produkt =  i*j;
				System.out.println(i + " x " + j + " = " + produkt);
			}
		}
	}
}