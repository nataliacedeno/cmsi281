public class CircularList {

    private Node head;
    private int  size;

    public CircularList() {
       head = null;
       size = 0;
    }

    public int getSize() {
       return size;
    }

    public void prepend( int dataToAdd ) {
       Node currentHead = head;
       head = new Node( dataToAdd );
       head.next = currentHead;
       size++;
    }
    public void insertAt(int i, int data){
       Node node = new Node (data);
       Iterator it = getIteratorAt(i-1);
       Iterator myIt = getIteratorAt(i);
       it.currentNode.next = node;
       node.next = myIt.currentNode;
    }

    public void removeAt(int i){
       Iterator it = getIteratorAt(i-1);
       Node temp = it.currentNode;
       it.next();
       it.next();
       temp.next = it.currentNode;
    }

    private class Node {

       int data;           
       Node next;           

       Node( int d ) {
          data = d;
          next = null;
       }
    }

    public Iterator getIteratorAt( int index ) {
       if( (index > size) || (index < 0) ) {
          throw new IllegalArgumentException();
       }
       Iterator it = new Iterator();
       while( index > 0 ) {
          it.next();
          index--;
       }
       return it;
    }
    public static void main(String[] args) {
        IntLinkedList myList = new IntLinkedList();
        myList.prepend( 23 );
        myList.prepend( 19 );
        myList.prepend( 17 );
        myList.prepend( 13 );
        myList.prepend( 11 );
        myList.prepend(  7 );
        myList.prepend(  5 );
        myList.prepend(  3 );
        myList.prepend(  2 );
        myList.insertAt(3, 74);
        myList.removeAt(7);
        IntLinkedList.Iterator myIt = myList.getIteratorAt(3);
        System.out.println(myIt.getCurrentInt());
        myIt = myList.getIteratorAt(7);
        System.out.println(myIt.getCurrentInt());
    }

    public class Iterator {
       private Node currentNode;

       Iterator() {
          currentNode = head;
       }

       public void next() {
          if( currentNode == null ) {
             return;
          } else {
             currentNode = currentNode.next;
          }
       }

       public boolean hasNext() {
          return ((currentNode != null) && (currentNode.next != null));
       }

       public int getCurrentInt() {
          return currentNode.data;
       }

    }
 }
