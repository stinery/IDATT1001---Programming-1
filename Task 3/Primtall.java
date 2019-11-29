import static javax.swing.JOptionPane.*;

class Primtall{
	public static void main(String[] args){
		String tallLest = showInputDialog("Tall: ");
		int tall = Integer.parseInt(tallLest);
		boolean primtall = true;

		if (tall%2 == 0){
			primtall = false;
		} else {
			for(int i = 3; i <= tall/2; i+= 2){
				if (tall%i == 0){
					primtall = false;
				}
			}
		}
		if (primtall){
			showMessageDialog(null, tall + " er ett primtall.");
		} else {
			showMessageDialog(null, tall + " er ikke ett primtall.");
		}
	}
}