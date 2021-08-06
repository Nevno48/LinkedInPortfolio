//
// Class used to test BinarySearchTree methods
//
// Lab tasks completed by:

public class Test {
    
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Test printAll
        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.printAll();
        System.out.println(bst.sum());
        System.out.println(bst.numLeaves());
        System.out.println(bst.contains(2));
        System.out.println(bst.numAs());
        System.out.println(bst.getSmallest());
        
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.add(56);
        bst2.add(72);
        bst2.add(48);
        bst2.add(91);
        bst2.add(40);
        bst2.printAll();
        System.out.println(bst2.sum());
        System.out.println(bst2.numLeaves());
        System.out.println(bst2.contains(72));
        System.out.println(bst2.numAs());
        System.out.println(bst2.getSmallest());
        
        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.add(100);
        bst3.add(101);
        bst3.add(102);
        bst3.add(103);
        bst3.add(99);
        bst3.add(98);
        bst3.add(97);
        bst3.add(96);
        bst3.printAll();
        System.out.println(bst3.sum());
        System.out.println(bst3.numLeaves());
        System.out.println(bst3.contains(2));
        System.out.println(bst3.numAs());
        System.out.println(bst3.getSmallest());
    }
}
