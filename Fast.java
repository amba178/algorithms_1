import java.util.*;

public class Fast {
     private static final int minNumberOfSameSlope = 4;
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
       
       ArrayList<Point> copyCollinearPoints = new ArrayList<Point>();
       for (int i = 0; i < points.length - 1; i++){
            //sort the array to respect of points[i]
            Arrays.sort(points,i, points.length, points[i].SLOPE_ORDER);
            ArrayList<Point> collinearPoints = new ArrayList<Point>();
            double currentSlope = points[i].slopeTo(points[i+1]);
            collinearPoints.add(points[i]);
            collinearPoints.add(points[i+1]);
            
            for ( int j = i + 2; j < points.length; j++){
                if(currentSlope == points[i].slopeTo(points[j]))
                {
                    collinearPoints.add(points[j]);
                }
               
                    
               if (collinearPoints.size() >= 4){
                    //get min and max than draw the line
                    Collections.min(collinearPoints).
                      drawTo(Collections.max(collinearPoints));
                }
                if( currentSlope != points[i].slopeTo(points[j]))
                {
                    ///for( Point point : collinearPoints)
                    // StdOut.println(point);
                    // StdOut.println();
                    // StdOut.println("i am here if stat");
                    if (collinearPoints.size() >= 4) {
                        if (copyCollinearPoints.isEmpty()){
                            copyCollinearPoints = collinearPoints;
                           
                        }/*else{
                            if (copyCollinearPoints.containsAll(collinearPoints) &&
                                collinearPoints.size() > copyCollinearPoints.size() ){
                                copyCollinearPoints = collinearPoints;
                                StdOut.println("I am here");
                            }
                        }*/
                            
                        for ( int k = 0; k < collinearPoints.size(); k++){
                             StdOut.print(collinearPoints.get(k).toString());
                             if ( k  < collinearPoints.size() - 1)
                                StdOut.print("->");
                           }
                           StdOut.println();
                   }
                    currentSlope = points[i].slopeTo(points[j]);
                    collinearPoints.clear();
                    collinearPoints.add(points[i]);
                    collinearPoints.add(points[j]);
                       
               }     
                
               }
           
          
            }   
              
           
       }
                
}

