;//
// A binary search tree data structure for storing floating point
// values. The tree has the property that for every node n, all values
// in n's left subtree are less than or equal to n's data value and
// all values in n's right subtree are larger.
//
// starter code by Siena College Faculty, modified by Jim Teresco
// for CSIS 210, Fall 2017
//
// Lab tasks completed by:
//
public class BinarySearchTree {

    private Node root; // top node in the tree

    // Constructor for objects of class BinarySearchTree. It
    // initializes an empty tree
    public BinarySearchTree() {

        root = null;
    }

    // inner Node class, no parent references here
    private class Node {
        private double data;
        private Node left;
        private Node right;

        private Node(double d, Node lt, Node rt) {
            data = d;
            left = lt;
            right = rt;
        }
    }

    // Adds the value to the tree. It maintains the binary search tree
    // property that for every tree node n, all values in n's left
    // subtree are less than or equal to n's data value and all values
    // in n's right subtree are larger.
    public void add(double value) {

        // inserting into an empty tree
        if (root == null) {
            root = new Node(value, null, null);
        }
        else {
            recursiveAdd(value, root);
        }
    }

    // Precondition: n is not null
    // Postcondition: value is inserted into the binary search tree
    // whose root is n
    public void recursiveAdd(double value, Node n) {

        if ((value > n.data) && (n.right == null)) {
            // value is added as the right child of n
            n.right = new Node(value, null, null);
        }
        else if ((value <= n.data) && (n.left == null)) {
            // value is added as the left child of n
            n.left = new Node(value, null, null);
        }
        else if ((value > n.data) && (n.right != null)) {
            // insert value into n's right subtree
            recursiveAdd(value, n.right);
        }
        else {
            // the following is true: ((value <= n.data) && (n.left != null))
            // insert value into n's left subtree
            recursiveAdd(value, n.left);
        }
    }

    // Prints the values in the tree 
    //
    public void printAll() {

        recursivePrintAll(root);
        System.out.println(""); // go to new line after printing all values
    }

    // Recursively prints the values out in the subtree whose root is n
    // 
    public void recursivePrintAll(Node n) {

        if (n == null) return;
        else {
            System.out.print(n.data + " "); 
            recursivePrintAll(n.left);
            recursivePrintAll(n.right);
        }
    }

    // place your implementations of numLeaves, numAs, and
    // getSmallest here

    /**
     *  Compute the sum of all values in the binary search tree.  Implement
     *  this recursively and you'll need a recursive helper method.
     *
     * @return the sum of values in the BST
     */
    public double sum() {
        return recursiveSum(root);
    }

    public double recursiveSum(Node n)
    {
        if(n == null)
        {
            return 0;
        }
        else
        {
            return recursiveSum(n.left) + recursiveSum(n.right) + n.data;
        }
    }

    public int numLeaves()
    {
        return recursiveNumLeaves(root);
    }

    public int recursiveNumLeaves(Node n)
    {
        if(n == null)
        {
            return 0;
        }
        else if(n.right == null && n.left == null)
        {
            return 1;
        }
        else
        {
            return recursiveNumLeaves(n.left) + recursiveNumLeaves(n.right);
        }
    }

    /**
     *  See if a value exists in the binary search tree.  Implement this
     *  recursively and you'll need a recursive helper method.
     *
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(double value) {

        return recursiveContains(value, root);
    }

    public boolean recursiveContains(double value, Node n)
    {
        if(n == null)
        {
            return false;
        }
        else if(value > n.data)
        {
            return recursiveContains(value, n.right);
        }
        else if(value < n.data)
        {
            return recursiveContains(value, n.left);
        }
        else 
        {
            return true;
        }
    }

    public int numAs()
    {
        return recursiveNumAs(root);
    }

    public int recursiveNumAs(Node n)
    {
        if(n == null)
        {
            return 0;
        }
        else if(n.data > 90 && n.data < 100)
        {
            return recursiveNumAs(n.right)  + recursiveNumAs(n.left)+ 1;
        }
        else 
        {
            return recursiveNumAs(n.right)  + recursiveNumAs(n.left);
        }
    }

    public double getSmallest()
    {
        return recursiveGetSmallest(root);
    }

    public double recursiveGetSmallest(Node n)
    {
        if(n.data < n.left.data)
        {
            return recursiveGetSmallest(n.left);
        }
        else
        {
            return n.data;
        }
    }

    /**
     * Adds the value to the binary search tree. Implement this 
     * iteratively.
     * 
     * @param value the value to insert into the tree
     */
    public void addIterative(double value) {
        add(value);
    }

    /**
     * Returns the largest value in the tree. Assumes the tree 
     * contains at least one value. All the work is done in 
     * the helper method that takes a Node for an argument.
     * So write your code in the next method!! Do not modify 
     * this one!
     * 
     * @return the largest value in the (non-empty) tree
     */
    public double getLargestIterative() {
        return getLargestIterative(root);
    }

    /**
     * Returns the largest value in the tree rooted at n. 
     * A precondition for calling this method is that the 
     * tree contains at least one value.  Implement this 
     * iteratively. Make sure you start looking for the largest
     * from node n, and not from the root of the entire tree!
     * 
     * @param n root of subtree being searched 
     * @return the largest value in subtree rooted at node n
     */
    private double getLargestIterative(Node n) {
        if(n.right == null)
        {
            return n.data;
        }
        else if(n.data < n.right.data)
        {
            return getLargestIterative(n.right);
        }
        else
        {
            return n.data;
        }
    }

    /**
     * Removes the largest value in the tree. 
     * All the work is done in the helper method that takes a Node 
     * for an argument. So write your code in the next method!! 
     * Do not modify this one!
     */
    public void removeLargestIterative() {
        // Case 1 - removing from empty tree
        if (root == null) return;
        // Case 2 - root node stores largest value
        if (root.right == null) {
            root = root.left;
            return;
        }
        // Case 3 - largest is not at the root
        removeLargestIterative(root);
    }

    /**
     * Removes the largest value in the tree rooted at n. 
     * Preconditions for calling this method are that 
     * n is not null and n itself does not contain the 
     * largest value in its subtree. In other words,
     * n.right != null. 
     * Implement this iteratively. Make sure you start 
     * looking for the largest starting from node n, and 
     * not from the root of the entire tree!
     * 
     * @param n root of subtree whose largest value is removed 
     */
    private void removeLargestIterative(Node n) {

    }

    /**
     * Removes one copy of the value from the tree. If value is
     * not in tree, it does nothing.
     * 
     * @param value the value being removed
     */
    public void remove(int value) {

        // Step 1: Find a node containing the value - do this  
        // by moving current down the tree until it points to
        // a node containing the value is found, with 
        // parentOfCurrent trailing behind it.
        Node current = null;
        Node parentOfCurrent = null;

        // Step 2: Remove the node
        // At this point, current should refer to a node containing
        // the value, or it is null if the value is not in the tree.
        // And parentOfCurrent should refer to..well, the
        // parent of current:-)
        //

        // Case 1 - current is null, meaning the value is not in 
        // the tree
        if (current == null) return;

        // Case 2 - current node has no children
        else if (current.left == null && current.right == null) {

            
        }

        // Case 3 - current node has only 1 child
        else if (current.left == null || current.right == null) {

            
        }
        // Case 4 - current has 2 children
        else if (current.left != null && current.right != null) {

            
        }
    }
}
