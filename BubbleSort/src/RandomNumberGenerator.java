import java.util.Random;

public class RandomNumberGenerator {

    public int[] randomNumberGenerator(int amount){
        Random rand = new Random();
        int[] a = new int[amount];
        for(int i=0; i<amount; i++){
            a[i] = rand.nextInt(1000);
        }
        return a;
    }
}
