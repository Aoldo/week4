package samples;


import java.util.Arrays;

import static java.lang.System.out;

/**
 * Arrays with objects (Complex objects).
 */
public class ArrayWithObjects {

    public static void main(String[] args) {
        new ArrayWithObjects().program();
    }

    void program() {
        Complex[] cArr = {new Complex(1, 2), new Complex(6, -1)};

        out.println(cArr[0]);
        out.println(cArr[0].img);

        Complex[] r = add(cArr, cArr);
        out.println(Arrays.toString(r));

    }


    // Assume c1.lenght == c2.length
    Complex[] add(Complex[] c1, Complex[] c2) {
        Complex[] result = new Complex[c1.length];
        for (int i = 0; i < c1.length; i++) {
            result[i] = c1[i].add(c2[i]);
        }
        return result;
    }


    // -------- Class for complex numbers (not finished) ----------

    class Complex {
        final double re;
        final double img;

        Complex(double re, double img) {
            this.re = re;
            this.img = img;
        }

        Complex(Complex c) {  // Copy constructor
            this(c.re, c.img);
        }

        // Always return a new Complex (because we normally assume operands won't change)
        Complex add(Complex other) {
            return new Complex(this.re + this.re, other.img + other.img);
        }

        Complex sub(Complex other) {
            return new Complex(this.re - this.re, other.img - other.img);
        }

        boolean equals(Complex other) {
            return this.re == other.re && this.img == other.img;
        }

        // Create a string representation of objects
        public String toString() {      // MUST have public first, more later ...
            if (re == 0 && img == 0) {
                return "0";
            } else if (re == 0) {
                return img + "i";
            } else if (img == 0) {
                return "" + re;   // Force conversion o String
            } else if (img > 0) {
                return re + " + " + (img + "i");
            } else {
                return re + " - " + (-1 * img + "i"); // Prettier
            }
        }
    }

}
