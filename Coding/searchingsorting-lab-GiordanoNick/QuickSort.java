/**
   Quicksort, based heavily on Java Structures example that
   sorts array of int rather than array of Comparable

   @author Jim Teresco, terescoj@cs.williams.edu, jteresco@siena.edu
*/
public class QuickSort {

    /**
       method to do a quicksort on an array of Comparable objects

       @param array array of Comparable elements
       @post array is sorted in ascending order
    */
    public static <T extends Comparable> void quickSort(T[] array) {

	quickSortRecursive(array, 0, array.length-1);
    }

    // pre: left <= right
    // post: array[left] placed in the correct (returned) location
    private static <T extends Comparable> int partition(T array[], 
							int left, int right) {
	while (true)
	{
	    // move right "pointer" toward left
	    while (left < right && array[left].compareTo(array[right]) < 0)
		right--;
	    if (left < right) swap(array, left++, right);
	    else return left;
	    // move left pointer toward right
	    while (left < right && array[left].compareTo(array[right]) < 0)
		left++;
	    if (left < right) swap(array, left, right--);
	    else return right;
	}
    }
	
    // pre: left <= right
    // post: array[left..right] in ascending order
    private static <T extends Comparable> void quickSortRecursive(T array[],
					   int left, int right) {
	int pivot;   // the final location of the leftmost value
	if (left >= right) return;
        pivot = partition(array, left, right);    /* 1 - place pivot */
	quickSortRecursive(array, left, pivot-1); /* 2 - sort small */
	quickSortRecursive(array, pivot+1, right);/* 3 - sort large */
        /* done! */
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
