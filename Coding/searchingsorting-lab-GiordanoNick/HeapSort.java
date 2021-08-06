/**
   Heap sort on an array of Comparable objects

   @author Jim Teresco, terescoj@cs.williams.edu, jteresco@siena.edu
*/
public class HeapSort {

    /**
       method to do a heap sort on an array of Comparable objects

       @param array array of Comparable elements
       @post array is sorted in ascending order
    */
    public static <T extends Comparable> void heapSort(T[] array) {
	// We first need to "heapify", thinking of the elements in the
	// array as being in an array representation of binary trees.
	// Helper methods below get the indices of parent and
	// left/right children.  Since we wish to sort the data in
	// ascending order, the heap must be a Max-Heap.  Elements in
	// the second half of the array are already trivial heaps, so
	// we start the process at the first location that has one or
	// two children.

	// index of the last element in the array
	int last = array.length-1;

	// for each position that has children, working backwards,
	// we treat it as a root being added to a heap, essentially
	// the pushDownRoot method of VectorHeap.
	for (int index = (last-1)/2; index >= 0; index--) {
	    pushDownRoot(array, index, array.length);
	}

	// we now have a valid heap we extract elements in reverse
	// sorted order, putting them at the end of the heap and into
	// their final position.  After each step, we need to heapify

	for (int index = last; index > 0; index--) {
	    T temp = array[index];
	    array[index] = array[0];
	    array[0] = temp;

	    pushDownRoot(array, 0, index);
	}
    }

    // next three methods borrowed from structure.VectorHeap
    /**
     * Returns parent index
     * @param i a node index
     * @return parent of node at i
     * @pre 0 <= i < size
     * @post returns parent of node at location i
     */
    protected static int parent(int i) {
	return (i-1)/2;
    }
    
    /**
     * Returns left child index.
     * @param i a node index
     * @return left child of node at i
     * @pre 0 <= i < size
     * @post returns index of left child of node at location i
     */
    protected static int left(int i) {
	return 2*i+1;
    }
    
    /**
     * Returns right child index.
     * @param i a node index
     * @return right child of node at i
     * @pre 0 <= i < size
     * @post returns index of right child of node at location i
     */
    protected static int right(int i) {
	return 2*(i+1);
    }

    /**
     * This method based heavily on structure.VectorHeap.pushDownRoot
     * Moves node downward, into appropriate position within a subheap.
     * This method assumes a Max-Heap structure.
     * @param array array of elements containing heap or near heap
     * @param root index of the root of the subheap
     * @param maxHeap index beyond which we do not have or want a heap
     * @pre 0 <= root < maxHeap
     * @post moves node at index root down to appropriate position in subtree
     */
    protected static <T extends Comparable> void pushDownRoot(T array[], 
				       int root, int maxHeap) {
	T value = array[root];
	while (root < maxHeap) {
	    int childPos = left(root);
	    if (childPos < maxHeap) {
		if ((right(root) < maxHeap) &&
		    (array[childPos+1].compareTo(array[childPos]) > 0)) {
		    childPos++;
		}
		// Assert: childPos indexes larger of two children
		if (array[childPos].compareTo(value) > 0) {
		    array[root] = array[childPos];
		    root = childPos; // keep moving down
		} else { // found right location
		    array[root] = value;
		    return;
		}
	    } else { // at a leaf! insert and halt
		array[root] = value;
		return;
	    }	    
	}
    }
}
