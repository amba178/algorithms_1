if (copyCollinearPoints.containsAll(collinearPoints)){
               // StdOut.println("True");
                
                if(collinearPoints.size() >= copyCollinearPoints.size()){
                    //StdOut.println(collinearPoints.size());
                    
                    for ( int k = 0; k < collinearPoints.size(); k++){
                        StdOut.print(collinearPoints.get(k).toString());
                        if ( k < collinearPoints.size() - 1)
                            StdOut.print("->");
                    }
                    StdOut.println();
                    
                }
             }
            //if distinct points in collinearPoints and size is  > 2
           if(!copyCollinearPoints.containsAll(collinearPoints) && collinearPoints.size() >= 4)
            {
                    for ( int k = 0; k < collinearPoints.size(); k++){
                        StdOut.print(collinearPoints.get(k).toString());
                        if ( k < collinearPoints.size() - 1)
                            StdOut.print("->");
                    }
                    StdOut.println();
            }
            }
            }   