import static javax.swing.JOptionPane.*;

class Skudd�r {
	public static void main(String[] args) {
		String �rstallLest = showInputDialog("�rstall: ");
		int �rstall = Integer.parseInt(�rstallLest);

		if (�rstall > 0){
			if (�rstall%400 == 0){
				showMessageDialog(null, �rstall + " er ett skudd�r!");
			} else if (�rstall%4 == 0 && �rstall%100 != 0){
				showMessageDialog(null, �rstall + " er ett skudd�r!");
			} else {
				showMessageDialog(null, �rstall + " er IKKE ett skudd�r.");
			}
		} else {
			showMessageDialog(null, "Ikke mulig!");
		}
	}
}