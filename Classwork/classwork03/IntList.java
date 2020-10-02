import sun.jvm.hotspot.utilities.IntArray;

public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      private class ListException extends Exception {
         public ListException( String m ) {
            super( m );
         }
      }

      private class EmptyListException extends Exception {
          public EmptyListException(String m) {
              super(m);
          }
      }

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) {
         try {
            if( size == 0 ) {
               throw new EmptyListException( "The list is empty!" );
            } else if( index > size ) {
               throw new ListException( "The index value is too large" );
            } else if( index < 0 ) {
               throw new ListException( "The index value is too small");
            }
         }
         catch( ListException le ) {}
         catch(EmptyListException ele){}
         return theList[index];
      }

      public boolean append( int valueToAdd ) {
         if( size < theList.length ) {
            theList[size] = valueToAdd;
            size++;
            return true;
         } else {
            int [] temp = theList;
            theList = new int [temp.length + STARTING_SIZE];
            for (int i=0;i<temp.length;i++) {
                theList[i] = temp [i];
            }
         }
         return false;
      }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }

      public int removeValueAtIndex( int index ) {
         int value = theList[index];
         try {
            if( size == 0 ) {
               throw new EmptyListException( "The list is empty!" );
            } else if( index > size ) {
               throw new ListException( "The index value is too large" );
            } else if( index < 0 ) {
               throw new ListException( "The index value is too small");
            }
         }
         catch( ListException le ) {}
         catch(EmptyListException ele){}
         holeFiller( index );
         return value;
      }

      // we've gotta have this to actually get things to compile
      public boolean insertValueAtIndex( int value, int index ) {
        if( size < theList.length ) {
            for (int i=size-1;i>=index; i--){
                theList[i+1]=theList[i];
            }
            theList[index]=value;
            size++;
            return true;
         } else {
            int [] temp = theList;
            theList = new int [temp.length + STARTING_SIZE];
            for (int i=0;i<temp.length;i++) {
                theList[i] = temp [i];
            } 
         }
         return false;
      }
      public boolean prepend(int value) {
          return insertValueAtIndex(value, 0);
      }

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 2 );
         list.append( 3 );
         list.append( 5 );
         list.append( 7 );
         System.out.println( list.getValueAtIndex( 3 ) );   // should return the value 7
         list.append( 11 );
         list.append( 13 );
         list.append( 17 );
         list.append( 19 );
         System.out.println( list.getValueAtIndex( 7 ) );      // should return the value 19
         System.out.println( list.removeValueAtIndex( 3 ) );   // should return the value 7
         System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         System.out.println( list.getValueAtIndex( 18 ) );     // just to see what happens

      }
   }