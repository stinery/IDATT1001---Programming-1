import static javax.swing.JOptionPane.*;

class Kjøttdeig {
	public static void main (String[] args){
		double merkeA = (35.90/450);
		double merkeB = (39.50/500);

		if (merkeA < merkeB){
			showMessageDialog(null, "Kjøttmerke A er billigst.");
		} else if (merkeA > merkeB){
			showMessageDialog(null, "Kjøttmerke B er billigst.");
		} else {
			showMessageDialog(null, "Kjøttmerke A og B er like billige.");
		}
	}
}

