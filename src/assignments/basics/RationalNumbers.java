package assignments.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.System.*;

/**
 * Class for rationals (below)
 */
public class RationalNumbers {

    public static void main(String[] args) {
        new RationalNumbers().program();
    }

    void program() {
        // This is testing. All output should print true
        Rational r = new Rational(2);
        out.println(r.num == 2 && r.denom == 1);    //Is this supposed to be here?

        r = new Rational(4, 9);
        out.println(r.num == 4 && r.denom == 9);
        r = new Rational(49, 168);
        out.println(r.num == 7 && r.denom == 24);
        r = new Rational(20, 4);
        out.println(r.num == 5 && r.denom == 1);
        r = new Rational(0, 1);
        out.println(r.num == 0 && r.denom == 1);

        r = new Rational(-49, 168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(49, -168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(-49, -168);
        out.println(r.num == 7 && r.denom == 24);

        Rational r1 = new Rational(1, 4);
        Rational r2 = new Rational(1, 2);
        out.println(r1.add(r2).equals(new Rational(3, 4)));

        out.println(r1.sub(r2).equals(new Rational(-1, 4)));

        out.println(r1.mul(r2).equals(new Rational(1, 8)));
        out.println(r1.div(r2).equals(new Rational(1, 2)));

        Rational r3 = new Rational(r1);
        out.println(r3.equals(r1));
        out.println(!r3.lessThan(r1));
        out.println(r3.toDouble() == 0.25); // Bit dangerous compare doubles

    }


    // -- The rational class -------------------------

    class Rational {
        final int num;
        final int denom;

        Rational(int num) {
            this.num = num;
            this.denom = 1;

        }

        Rational(int num, int denom) {
            int greatsetcommondenom = greatestCommonDenominator(num, denom);

            num = num / greatsetcommondenom;
            denom = denom / greatsetcommondenom;

            //Make num negative if negative.
            if (denom < 0 && num > 0) {
                denom *= -1;
                num *= -1;
            }

            this.num = num;
            this.denom = denom;
        }

        int greatestCommonDenominator(int a_in, int b_in) {
            if (b_in == 0) {
                return a_in;
            }
            return (greatestCommonDenominator(b_in, a_in % b_in));
        }

        boolean equals(Rational inrat) {
            return (inrat.num == num && inrat.denom == denom) || (inrat.num == -num && inrat.denom == -denom);

        }

        Rational(Rational inrational) {
            this.num = inrational.num;
            this.denom = inrational.denom;
        }

        // Add methods below this
        double toDouble() {
            return (double) num / denom;
        }


        Rational mul(Rational inrat) {
            return new Rational(num * inrat.num, denom * inrat.denom);
        }

        Rational div(Rational inrat) {
            return new Rational(num * inrat.denom, denom * inrat.num);
        }

        Rational sub(Rational inrat) {
            int newnum = num * inrat.denom - inrat.num * denom;
            int newdenom = inrat.denom * denom;
            return new Rational(newnum, newdenom);
        }

        boolean lessThan(Rational inrat) {
            if (num * inrat.denom < inrat.num * denom)
                return true;
            return false;
        }

        Rational add(Rational inrat) {
            int newnum = num * inrat.denom + inrat.num * denom;
            int newdenom = inrat.denom * denom;


            return new Rational(newnum, newdenom);
        }
    }
}