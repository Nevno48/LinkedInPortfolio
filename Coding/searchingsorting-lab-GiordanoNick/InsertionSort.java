/**
   Recursive insertion sort of an array of Comparable objects

   @author Jim Teresco, terescoj@cs.williams.edu, jteresco@siena.edu
*/
public class InsertionSort {

    /**
       recursive method to do a insertion sort on an array of Comparable objects
       @param array array of Comparable elements
       @post array is sorted in ascending order
    */
    public static <T extends Comparable> void insSort(T[] array) {
	
	recInsSort(array.length-1, array);
    }

    /**
       helper method to do the actual recursive insertion sort

       @param lastIndex the index beyond which the array is already sorted
       @param array the array of Comparable elements
       @pre array is sorted from position lastIndex to array.length-1
       @post array is sorted
    */
    protected static <T extends Comparable> void 
		     recInsSort(int lastIndex, T[] array) {
	// stopping condition: is there more than 1 element to sort?
	if (lastIndex > 0) {

	    // first sort 0..lastIndex-1, recursively
	    recInsSort(lastIndex-1, array);

	    // position is index where last will be inserted
	    int position = lastIndex-1;  

	    // search for first element (from rear) which is <= array[lastIndex]
	    while (position >= 0 && 
		   array[lastIndex].compareTo(array[position]) < 0)
		position--;
	    
	    position++; // insert array[index] at position
	    
	    // move array[position .. last-1] to put in array[last]
	    T temp = array[lastIndex];
	    for (int moveIndex = lastIndex-1; moveIndex >= position; moveIndex--)
		array[moveIndex+1] = array[moveIndex];
	    
	    // insert element into proper position
	    array[position] = temp;
	    // now array[0..last] are in order, return to caller
	}
    }
}
