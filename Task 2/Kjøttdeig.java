import static javax.swing.JOptionPane.*;

class Kj�ttdeig {
	public static void main (String[] args){
		double merkeA = (35.90/450);
		double merkeB = (39.50/500);

		if (merkeA < merkeB){
			showMessageDialog(null, "Kj�ttmerke A er billigst.");
		} else if (merkeA > merkeB){
			showMessageDialog(null, "Kj�ttmerke B er billigst.");
		} else {
			showMessageDialog(null, "Kj�ttmerke A og B er like billige.");
		}
	}
}

