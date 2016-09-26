package samples;

import static java.lang.System.out;

/**
 * Class and Instance
 */
public class ClassAndInstance {

    public static void main(String[] args) {
        new ClassAndInstance().program();
    }


    void program() {
        // Instantiation. Use the new type to declare a reference variable
        // and call constructor to create the object.
        Country c1 = new Country();

        out.println(c1); // Not so good ... (more later)


        // Dot notation
        c1.nDices = 3;
        c1.neighbours = 114;
        c1.owner = "fia";

        out.println(c1.nDices);
        out.println(c1.owner);
        out.println(c1.hasBorder(4));

        Country c2 = new Country();  // A completely different object
        c1.nDices = 3;
        c1.neighbours = 145;
        c1.owner = "pelle";

        out.println(c1.nDices == c2.nDices);  // Yes, VALUE same (two different variables)
        out.println(c1.neighbours == c2.neighbours); // No value not same

    }

    // Class declaration, a class named Country (introduces a new type!)
    class Country {
        String owner;     // Instance variables
        int neighbours;
        int nDices;

        boolean hasBorder(int to) {
            int tmp = neighbours;   // neighbours in scope
            while ( tmp > 1) {
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




