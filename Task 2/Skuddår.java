import static javax.swing.JOptionPane.*;

class Skuddår {
	public static void main(String[] args) {
		String årstallLest = showInputDialog("Årstall: ");
		int årstall = Integer.parseInt(årstallLest);

		if (årstall > 0){
			if (årstall%400 == 0){
				showMessageDialog(null, årstall + " er ett skuddår!");
			} else if (årstall%4 == 0 && årstall%100 != 0){
				showMessageDialog(null, årstall + " er ett skuddår!");
			} else {
				showMessageDialog(null, årstall + " er IKKE ett skuddår.");
			}
		} else {
			showMessageDialog(null, "Ikke mulig!");
		}
	}
}