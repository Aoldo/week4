package samples;

import static java.lang.System.*;

/**
 * ComplexNumb is a class for complex numbers.
 */
public class ComplexNumbers {


    public static void main(String[] args) {
        new ComplexNumbers().program();
    }

    void program() {
        // Just some testing
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(-3, -5);
        Complex c3 = new Complex(c2);     // Copy Constructor

        out.println(c3.equals(c2));
        out.println(c1.sub(c2));
        out.println(c2.add(c1).add(c3).add(c3));  // Chained call
    }


    // -------- Class for complex numbers (not finished) ----------

    class Complex {
        final double re; // We will not allow a ComplexNumb to change (possible behind our back), so final
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
