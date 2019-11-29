import static javax.swing.JOptionPane.*;

class MinRandom{
	java.util.Random random = new java.util.Random();

	public MinRandom(){
	}
	public int nesteHeltall(int nedre, int ovre){
		return  random.nextInt(ovre - nedre) + nedre;
	}
	public double nesteDesimal(double nedre, double ovre){
		return (ovre-nedre) * random.nextDouble() + nedre;
	}
}
//Klientprogram
class Random{
	public static void main(String[] args){
		MinRandom b = new MinRandom();

		//Øvre og nedre grense for heltall
		String fhLest = showInputDialog("Heltall\nFra: ");
		int fh = Integer.parseInt(fhLest);
		String thLest = showInputDialog("Heltall\nTil: ");
		int th = Integer.parseInt(thLest);

		//Øvre og nedre grense for desimaltall
		String fdLest = showInputDialog("Desimaltall\nFra: ");
		double fd = Double.parseDouble(fdLest);
		String tdLest = showInputDialog("Desimaltall\nTil: ");
		double td = Double.parseDouble(tdLest);

		System.out.println("Ditt heltall mellom " + fh + " og " + th + " er: " + b.nesteHeltall(fh, th) + "\n\nDitt desimaltall mellom " + fd + " og " + td + " er: " + b.nesteDesimal(fd, td) + "\n");
	}
}