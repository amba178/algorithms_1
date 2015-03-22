/*************************************************************************
 * Name:salem Amba
 * Email:salemamba@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    // YOUR DEFINITION HERE
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder(); 
    
    // x coordinate
    private final int x;  
    // y coordinate
    private final int y;                             
    
    private class SlopeOrder implements Comparator<Point>
    {
        public int compare(Point a, Point b)
        { 
            if (a == null || b == null)
               throw new NullPointerException("point can not be null");
            double slope1= slopeTo(a);
            double slope2 = slopeTo(b);
            
            return Double.compare(slope1, slope2);
         }
    }
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) 
    {   
        if (that == null || this == null)
             throw new  NullPointerException("point can not be null");
        //horizontal slope
        if (that.y == this.y && this.x != that.x) return +0.0;
        //vertical slope
        if (that.x == this.x && that.y != this.y)
             return Double.POSITIVE_INFINITY;
        //degenerate segment slope
        if ( this.y == that.y && that.x == this.x) 
             return Double.NEGATIVE_INFINITY;
        //normal line slope
        return (double)(that.y - this.y)/(that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if(that == null || this == null)
            throw new NullPointerException();
            
        if ( this.y < that.y) return -1;
        if ( this.y == that.y && this.x < that.x ) return -1;
        if ( this.y > that.y) return +1;
        if ( this.y == that.y && this.x > that.x) return +1;
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        
        Point point1, point2;
        point1 = new Point(5, 10);
        point2 = new Point(5 , 7);
      
        assert point1.slopeTo(point2) == Double.POSITIVE_INFINITY  : "shoiuld be positive infinity"; 
       
        point1 = new Point(7, 3);
        point2 = new Point(8 , 3);
        
        assert point1.slopeTo(point2) == +0.0  : "should be positive zero";
        
        
        point1 = new Point(7, 3);
       // point2 = new Point(8 , 3);
        
        assert point1.slopeTo(point1) == Double.NEGATIVE_INFINITY  : "should be negative infinity";
    }
}