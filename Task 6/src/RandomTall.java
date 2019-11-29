import java.util.Random;

public class RandomTall {
    public static void main(String[] args){
        int [] antall = new int [10];
        java.util.Random random = new Random();

        for(int i = 0; i < 10000; i++){
            int tall = random.nextInt(10);
            antall[tall]++;

        }

        for(int j = 0; j < antall.length; j++) {
            System.out.println(j + ": " + antall[j]);

        }

    }

}
