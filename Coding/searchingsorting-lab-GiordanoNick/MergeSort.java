/**
   Merge sort, based heavily on Java Structures example that
   sorts array of int rather than array of Comparable

   @author Jim Teresco, terescoj@cs.williams.edu, jteresco@siena.edu
*/
public class MergeSort {

    /**
       method to do a mergesort on an array of Comparable objects

       @param array array of Comparable elements
       @post array is sorted in ascending order
    */
    public static <T extends Comparable> void mergeSort(T array[]) {
	mergeSortRecursive(array,(T[])(new Comparable[array.length]),
			   0, array.length-1);
    }
    
    // pre: 0 <= low <= high < array.length
    // post: values in array[low..high] are in ascending order
    private static <T extends Comparable> 
			      void mergeSortRecursive(T array[], 
						      T temp[], 
						      int low, int high) {
	int n = high - low + 1;
	int middle = low + n/2;
	int i;

	if (n < 2) return;
	// move lower half of array into temporary storage
	for (i = low; i < middle; i++) {
	    temp[i] = array[i];
	}
	// sort lower half of array
	mergeSortRecursive(temp, array, low, middle-1);
	// sort upper half of array
	mergeSortRecursive(array, temp, middle, high);
	// merge halves together
	merge(array, temp, low, middle, high);
    }
    
    // pre: array[middle..high] are ascending
    //      temp[low..middle-1] are ascending
    // post: array[low..high] contains all values in ascending order
    private static <T extends Comparable> 
			      void merge(T array[], T temp[],
					 int low, int middle, int high) {
	int ri = low; // result index
	int ti = low; // temp index
	int di = middle; // destination index
	// while two lists are not empty merge smaller value
	while (ti < middle && di <= high) {
	    if (array[di].compareTo(temp[ti]) < 0) {
		array[ri++] = array[di++]; // smaller is in high array
	    } else {
		array[ri++] = temp[ti++]; // smaller is in temp
	    }
	}
	// possibly some values left in temp array
	while (ti < middle) {
	    array[ri++] = temp[ti++];
	}
	// ...or some values left (in correct place) in array
    }

    // pre: 0 <= i,j < array.length
    // post: array[i] and array[j] are exchanged
    public static <T extends Comparable> void swap(T array[], int i, int j) {
	T temp;
	temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }
}
