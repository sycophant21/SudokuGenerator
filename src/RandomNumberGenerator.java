import java.util.Random;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int lessThan, boolean addOneOrNot) {
        if (addOneOrNot) {
            return (new Random().nextInt(lessThan)) + 1;
        }
        else {
            return (new Random().nextInt(lessThan));
        }
    }
}
