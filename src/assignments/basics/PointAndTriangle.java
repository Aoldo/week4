package assignments.basics;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 * Basic use of classes
 */
public class PointAndTriangle {

    public static void main(String[] args) {
        new PointAndTriangle().program();
    }

    void program() {

        // Printing result from solutions. Expected outcome as comment
        Point p = new Point(1, 2, 3);
        out.println(p.distance(new Point(p)));  // 0.0
        out.println(new Point(0, 0, 0).distance(new Point(1, 0, 0)));  // 1.0
        Triangle t = new Triangle(new Point(0, 0, 0), new Point(0, 1, 0), new Point(1, 0, 0));
        out.println(t.area());   // 0.49999999999999983
    }

    // ---------- Write your classes below this line ----------------------------

    // A class for points in 3D
    class Point {
        final double x;
        final double y;
        final double z;

        Point(Point otherpoint)
        {
            x = otherpoint.x;
            y = otherpoint.y;
            z = otherpoint.z;
        }
        Point(double x, double y, double z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        double distance(Point otherpoint)
        {
            double dx = x-otherpoint.x;
            double dy = y-otherpoint.y;
            double dz = z-otherpoint.z;

            return (Math.sqrt(dx*dx+dy*dy+dz*dz));
        }
    }

    // A class for a Triangle in 3D
    class Triangle {
        Point[] points = new Point[3];
        Triangle(Point p0, Point p1, Point p2)
        {
            points[0] = p0;
            points[1] = p1;
            points[2] = p2;
        }
        /*
        Herons: A= sqrt( s* (s-a)(s-b)(s-c))
        s = (a+b+c)/2
         */
        double area()
        {
            double a = points[0].distance(points[1]);
            double b = points[1].distance(points[2]);
            double c = points[2].distance(points[0]);

            double s = (a+b+c)/2;



            return (sqrt(s*(s-a)*(s-b)*(s-c)));
        }
    }

}
