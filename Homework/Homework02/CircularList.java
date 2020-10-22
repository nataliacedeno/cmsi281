/**
 *  File name: CircularList.java
 *  Purpose: implements a circular linked list
 * @author: Hayden Crabbs
 * @author: Natalia Cedeno
 */
public class CircularList {

   private Node current;
   private Node head;
   public int size;

   /**
    * Constructor
    */
   public CircularList() {
      current = null;
      size = 0;
   }

   /**
    * Returns size of list
    * @return int size of list
    */
   public int getSize() {
      return size;
   }

   /**
    * Returns current node's data
    * @return int current data
    */
   public int getCurrentData() {
      return current.data;
   }

   /**
    * Returns current node
    * @return Node current node
    */
   public Node getCurrent() {
      return current;
   }

   /**
    * Sets current node
    * @param n Node node to set current to
    */
   public void setCurrent(Node n) {
      current = n;
   }

   /**
    * Inserts node containing data at current.next and becomes the new current
    * @param data int data to be inserted
    */
   public void insert(int data) {
      Node node = new Node(data);
      if (size == 0) {
         node.next = node;
         current = node;
         head = node;
      } else if (current.next == head) {
         current.next = node;
         node.next = head;
      } else {
         node.next = current.next;
         current.next = node;
      }
      step();
      size++;
   }

   /**
    * Removes node at current.next
    */
   public void remove() {
      if (size == 0) {
         System.out.println("Circular list empty. Cannot remove.\n");
      } else {
         current.next = current.next.next;
         head = current.next;
         size--;
      }
   }

   /**
    * Moves current to next item in list
    */
   public void step() {
      current = current.next;
   }

   /**
    * Rotates circular list so that the node containing the data being searched for is in the current.next position
    * @param data int data seaching for
    * @return Node containing data being searched for, or null if not found
    */
   public Node findNext(int data) {
      int i = 0;
      while (current.next.data != data || i < size) {
         step();
         i++;
      }
      if (i == size) {
         System.out.println("Not found");
         return null;
      }
      head = current.next;
      return head;
   }

   /**
    * Displays list with current at the end
    */
   public void display() {
      System.out.println();
      for (int i = 0; i < size; i++) {
         step();
         System.out.print("[" + current.data + "]");
      }
      System.out.println("\nCurrent: " + current.data);
   }

   /**
    * Defines node class
    */
   class Node {
      int data;
      Node next;

      Node(int d) {
         data = d;
         next = null;
      }
   }

   /**
    * Main to test methods
    * @param args
    */
   public static void main(String[] args) {
      CircularList l = new CircularList();
      l.insert(1);
      l.insert(2);
      l.display();
      l.insert(3);
      l.display();
      l.insert(4);
      l.display();
      l.insert(5);
      l.display();
      l.insert(6);
      l.display();
      System.out.println("\nRemoving...");
      l.remove();
      l.display();
      System.out.println("\nFinding 3...");
      l.findNext(3);
      l.display();
      System.out.println("\nRemoving...");
      l.remove();
      l.display();
   }
}
