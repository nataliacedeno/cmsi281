public class CircularList {

   private Node current;
   private Node head;
   public int size;

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

   public Node getCurrent() {
      return current;
   }

   public void setCurrent(Node n) {
      current = n;
   }

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

   public void remove() {
      if (size == 0) {
         System.out.println("Circular list empty. Cannot remove.\n");
      } else {
         current.next = current.next.next;
         head = current.next;
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
      if (i == size) {
         System.out.println("Not found");
         return null;
      }
      head = current.next;
      return head;
   }

   public void display() {
      System.out.println();
      for (int i = 0; i < size; i++) {
         step();
         System.out.print("[" + current.data + "]");
      }
      System.out.println("\nCurrent: " + current.data);
      System.out.println("Head: " + head.data);
   }

   class Node {
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
      l.display();
      l.remove();
      l.display();
   }
}
