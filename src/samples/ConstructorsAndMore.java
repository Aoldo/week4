package samples;

import static java.lang.System.out;

/**
 * Class and Instance
 */
public class ConstructorsAndMore {

    public static void main(String[] args) {
        new ConstructorsAndMore().program();
    }


    void program() {
        // NO! No default constructor
        //Country c1 = new Country();

        Country c1 = new Country("fia", 114, 3);
        Country c2 = new Country("fia");
        Country c3 = new Country(c2);

        c1.nDices = 5;
        out.println( c1.nDices != c3.nDices);  // Two distinct objects

    }

    // Class declaration, a class named Country (introduces a new type!)
    class Country {
        String owner;     // Instance variables
        int neighbours;
        int nDices;

        // NOTE: Default constructor gone, because we have declared own
        Country(String owner, int neighbours, int nDices) {
            this.owner = owner;
            this.neighbours = neighbours;
            this.nDices = nDices;

        }

        // Overloaded constructor
        Country(String owner) {
            this.owner = owner;
            neighbours = -1;
            nDices = -1;

        }

        // Copy constructor (also overloaded)
        Country(Country other) {
            owner = other.owner;
            neighbours = other.neighbours;
            nDices = other.nDices;
        }


        boolean hasBorder(int to) {
            int tmp = neighbours;   // neighbours in scope
            while (tmp > 1) {
                int d = tmp % 10;
                if (d == to) {
                    return true;
                }
                tmp = tmp / 10;
            }
            return false;
        }

    }
}




