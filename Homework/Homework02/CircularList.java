public class CircularList {

   private Node current;
   private int size;

   public CircularList() {
      current = null;
      size = 0;
   }

   public int getSize() {
      return size;
   }

   public int getCurrentData() {
      return current.data;
   }

   public void insert(int data) {
      Node node = new Node(data);
      if (size == 0) {
         node.next = node;
         current = node;
      } else {
         node.next = current.next;
         current.next = node;
      }
      step();
      size++;
   }

   public void remove() {
      if (size == 0) {
         System.out.println("Circular list empty. Cannot remove.\n");
      } else {
         current.next = current.next.next;
         size--;
      }
   }

   public void step() {
      current = current.next;
   }

   public Node findNext(int d) {
      int i = 0;
      while (current.next.data != d || i < size) {
         step();
         i++;
      }
      return current.next;
   }

   public void display() {
      System.out.println();
      for (int i = 0; i < size; i++) {
         System.out.print("[" + current.next.data + "]");
         step();
      }
      System.out.println("\nCurrent: " + current.next.data);
   }

   private class Node {
      int data;
      Node next;

      Node(int d) {
         data = d;
         next = null;
      }
   }

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
      l.remove();
      l.display();
      l.findNext(3);
      l.remove();
      l.display();
   }
}
