import java.util.*;

public class Brute {
    public static void main(String[] args){ 
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        // make the points a bit larger
        StdDraw.setPenRadius(0.01);  
        
        //read file name for standaard input
        String filename = args[0];
        
        Point[] points = readFile(filename);
        findCollinearPoints(points);
    }
        
   private static Point[] readFile(String filename){
            //Read data from input file
            In in = new In(filename);
            
            int dataSize = in.readInt();
            
            Point[] points = new Point[dataSize];
            for(int rowRead = 0; rowRead < dataSize; rowRead++){
                int x = in.readInt();
                int y = in.readInt();
                
                points[rowRead] = new Point(x, y);
                points[rowRead].draw();
            }
            
           // reset the pen radius
           StdDraw.setPenRadius(); 
            
           return points;
     }
   private static void findCollinearPoints(Point[] points){
        //comparing slope of four points
        for(int first = 0; first < points.length - 3; first++){
            for(int second = first + 1; second < points.length - 2; second++){
                for(int third = second + 1; third  < points.length - 1; third++){
                    for(int fourth = third + 1; fourth < points.length;     fourth++){
                        double slopeFirstSecond = points[first].slopeTo(points[second]);
                        double slopeFirstThird = points[first].slopeTo(points[third]);
                        double slopeFirstFourth = points[first].slopeTo(points[fourth]);
                        if(slopeFirstSecond == slopeFirstThird && slopeFirstSecond == slopeFirstFourth){
                            Point[] result = new Point[4];
                            result[0] = points[first];
                            result[1] = points[second];
                            result[2] = points[third];
                            result[3] = points[fourth];
                            Arrays.sort(result);
                            
                            //Output to standard out and draw
                            StdOut.print(result[0]);
                            StdOut.print(" -> ");
                            StdOut.print(result[1]);
                            StdOut.print(" -> ");
                            StdOut.print(result[2]);
                            StdOut.print(" -> ");
                            StdOut.print(result[3]);
                            StdOut.println();
                            
                            result[0].drawTo(result[3]);
                            
                        }
                        
                    }
                }
            }
        }
            
   }
        
}
