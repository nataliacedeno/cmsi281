import java.util.*;

public class BreadthFirstSearcher {
    private static LinkedList<Character> queue = new LinkedList<>();
    private static final int TEST_GRAPH_SIZE = 9;
    private static char [] output = new char[TEST_GRAPH_SIZE];
    private static int index = 0; 
    private static char current;
    
    public static void bfs( Graph graph, char currentVertex ) {
        current = currentVertex;
        graph.markVisited( current );
        output[index++] = current;

        for( char nextVertex = 'A'; nextVertex <= 'I'; nextVertex ++ ) {
            if( graph.areTwoVertexsConnected( current, nextVertex ) ) {
    
                if( !graph.wasVisited( nextVertex ) ) {
                    queue.add(nextVertex);
                    bfs(graph, nextVertex);
                }
            }
        }
    
    }
    public static void main( String [] args )
    {
      // Create a new graph wih 8 Vertexs, which will be named 'A' through 'I'
       Graph theGraph = new Graph( TEST_GRAPH_SIZE );
 
      // Create links between the Vertexs.
       theGraph.linkTwoVertexs( 'A', 'B' );
       theGraph.linkTwoVertexs( 'A', 'C' );
       theGraph.linkTwoVertexs( 'A', 'D' );
       theGraph.linkTwoVertexs( 'A', 'E' );
       theGraph.linkTwoVertexs( 'B', 'F' );
       theGraph.linkTwoVertexs( 'F', 'H' );
       theGraph.linkTwoVertexs( 'D', 'G' );
       theGraph.linkTwoVertexs( 'G', 'I' );
 
      // Do a depth first search on theGraph starting from 'E'
       bfs( theGraph, 'A' );
       System.out.print( "\n   Output list of vertices: " );
       for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
         System.out.print( output[i] + " " );
       }
       System.out.println( );
 
       System.out.println( "\n\n   Starting over again, same graph, from 'G'... " );
       theGraph = new Graph( TEST_GRAPH_SIZE );
 
      // Create links between the Vertexs.
       theGraph.linkTwoVertexs( 'A', 'B' );
       theGraph.linkTwoVertexs( 'A', 'C' );
       theGraph.linkTwoVertexs( 'A', 'D' );
       theGraph.linkTwoVertexs( 'A', 'E' );
       theGraph.linkTwoVertexs( 'B', 'F' );
       theGraph.linkTwoVertexs( 'F', 'H' );
       theGraph.linkTwoVertexs( 'D', 'G' );
       theGraph.linkTwoVertexs( 'G', 'I' );
       index = 0;
       bfs( theGraph, 'G' );
       System.out.print( "\n   Output list of vertices: " );
       for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
         System.out.print( output[i] + " " );
       }
       System.out.println( );
 
    } 
}
