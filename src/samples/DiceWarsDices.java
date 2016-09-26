package samples;

import java.util.Random;

import static java.lang.System.out;

/**
 * Simple class using other class (i.e. Random)
 * <p>
 * NOTE: This is a model of "real" object!
 */
public class DiceWarsDices {

    public static void main(String[] args) {
        new DiceWarsDices().program();
    }


    void program() {
        // Instantiate
        Dices ds = new Dices();
        out.println(ds.roll(3));
    }

    // Class declaration
    class Dices {
        // Reference variable to other object
        final Random rand = new Random();

        int roll(int nDices) {
            int total = 0;
            for (int i = 0; i < nDices; i++) {
                total += rand.nextInt(6) + 1;
            }
            return total;
        }

    }
}




