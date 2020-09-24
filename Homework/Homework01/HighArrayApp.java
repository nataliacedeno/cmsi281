class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(99);
        arr.insert(66);
        arr.insert(00);
        arr.insert(33);
        arr.display();
        int searchKey = 35;
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        arr.display();

        HighArray arr2;
        arr2 = new HighArray(maxSize);
        System.out.println("\nArray 2:");
        System.out.println("Max: " + arr2.getMax());
        arr2.insert(1);
        arr2.insert(3);
        arr2.display();
        System.out.println("Max: " + arr2.getMax());
        arr2.insert(14);
        arr2.insert(5);
        arr2.insert(5);
        arr2.insert(24);
        arr2.display();
        System.out.println("Max: " + arr2.getMax());
        arr2.insert(4);
        arr2.insert(5);
        arr2.insert(3);
        arr2.display();
        System.out.println("Max: " + arr2.getMax());
        arr2.insert(3);
        arr2.insert(2);
        arr2.insert(4);
        arr2.insert(2);
        arr2.insert(2);
        arr2.insert(34);
        arr2.display();
        System.out.println("Max: " + arr2.getMax());
        arr2.display();
        System.out.println("No Dups: ");
        arr2.noDups();
        arr2.display();
    }
}
