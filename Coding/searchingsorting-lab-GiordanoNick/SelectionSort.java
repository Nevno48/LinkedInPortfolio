/**
   Recursive selection sort on an array of Comparable objects

   @author Jim Teresco, terescoj@cs.williams.edu
*/
public class SelectionSort {

    /**
       recursive method to do a selection sort on an array of Comparable objects
       @param array array of Comparable elements
       @post array is sorted in ascending order
    */
    public static <T extends Comparable> void selSort(T[] array) {
	
	recSelSort(array.length-1, array);
    }

    /**
       helper method to do the actual recursive selection sort

       @param lastIndex the index beyond which the array is already sorted
       @param array the array of Comparable elements
       @pre array is sorted from position lastIndex to array.length-1
       @post array is sorted
    */
    protected static <T extends Comparable> 
				void recSelSort(int lastIndex, T[] array) {
	// stopping condition: is there more than 1 element left to sort?
	if (lastIndex > 0) {
	    int extreme = 0;    // to store the index of largest element
	    
	    // Search for that index of the largest element
	    for (int searchIndex = 1; searchIndex <= lastIndex; searchIndex++) {
		if (array[extreme].compareTo(array[searchIndex]) < 0)
		    extreme = searchIndex;
	    }
	    
	    // swap largest element (at extreme) with the one at lastIndex
	    T temp = array[extreme];
	    array[extreme] = array[lastIndex];
	    array[lastIndex] = temp;
	    // Assert: array[lastIndex] now largest in array[0..lastIndex]
	    
	    recSelSort(lastIndex-1,array);
	    // Assert: array[0..lastIndex] are sorted.
	}
    }
}
