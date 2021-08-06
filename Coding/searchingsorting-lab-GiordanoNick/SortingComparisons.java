import structure5.*;

/**
   Comparisons of advanced sorting procedures, operating on arrays of
   Comparable elements

   @author Jim Teresco, terescoj@cs.williams.edu, jteresco@siena.edu
*/

public class SortingComparisons {

    /**
       Make a copy of an array

       @param a array to be cloned
       @return new array containing same objects as a
    */
    protected static Integer[] clone(Integer[] a) {

	Integer copy[] = new Integer[a.length];
	for (int i=0; i<a.length; i++) {
	    copy[i] = a[i];
	}
	return copy;
    }

    /**
       Main method to compare sorting procedures <BR>
       Takes the size of an array of Intgers to be generated as its
       only command-line parameter.<BR>
       Sorts with each of several procedures, timing them.<BR>
       Prints the times taken by each procedure for random data, 
       ascending data, descending data.<BR>

       @param args command-line parameter: args[0] is array length
    */
    public static void main(String[] args) {

	// pull array size from command line parameter
	if (args.length != 1) {
	    System.out.println("Usage: java SortingComparisons arrayLength");
	    return;
	}
	int i, n;
	try {
	    n = (new Integer(args[0]));
	}
	catch(NumberFormatException e) {
	    System.out.println("Usage: java SortingComparisons arrayLength");
	    return;
	}

	// make sure we have at least 2 elements (normally should be 
	// much larger, of course)
	if (n < 2) {
	    System.out.println("Specify array size of at least 2.");
	    return;
	}
       
	// create some arrays to work with, one with random values in the
	// range 0 to 2n, then an ascending array and a descending array,
	// using the same values for consistency
	    
	System.out.println("Generating random arrays of size " + n + ".");
	Integer randomData[] = new Integer[n];
	java.util.Random r = new java.util.Random();
	for (i = 0; i < n; i++) {
	    randomData[i] = r.nextInt(2*n);
	}
	Integer ascendingData[] = clone(randomData);
	QuickSort.quickSort(ascendingData);

	Integer descendingData[] = new Integer[n];
	for (i = 0; i < n; i++) {
	    descendingData[i] = ascendingData[n-1-i];
	}

	// set up for our sorting tests
	// in each case, we clone one of the input arrays (so we can sort
	// it without destroying the original), then time one of the
	// sorting algorithms

	// note the mechanism to call a static method in another class:
	// ClassName.methodName()
	long startTime, duration;
	Integer data[];


	/* Selection Sort */
	System.out.println("Selection sort:");

	data = clone(randomData);

	startTime = System.currentTimeMillis();
	SelectionSort.selSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	SelectionSort.selSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	SelectionSort.selSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

	/* Insertion Sort */
	System.out.println("Insertion sort:");
	data = clone(randomData);

	startTime = System.currentTimeMillis();
	InsertionSort.insSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	InsertionSort.insSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	InsertionSort.insSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

	/* Merge Sort */
	System.out.println("Merge sort:");
	data = clone(randomData);

	startTime = System.currentTimeMillis();
	MergeSort.mergeSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	MergeSort.mergeSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	MergeSort.mergeSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

	/* Heap Sort */
	System.out.println("Heap sort:");
	data = clone(randomData);

	startTime = System.currentTimeMillis();
	HeapSort.heapSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	HeapSort.heapSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	HeapSort.heapSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

	/* Tree Sort */
	System.out.println("Tree sort:");
	data = clone(randomData);

	startTime = System.currentTimeMillis();
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	for (i=0; i<n; i++) bst.add(data[i]);
	java.util.Iterator<Integer> iter = bst.iterator();
	i=0;
	while (iter.hasNext()) {
	    data[i++] = iter.next();
	}
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	bst = new BinarySearchTree<Integer>();
	for (i=0; i<n; i++) bst.add(data[i]);
	iter = bst.iterator();
	i=0;
	while (iter.hasNext()) {
	    data[i++] = iter.next();
	}
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	bst = new BinarySearchTree<Integer>();
	for (i=0; i<n; i++) bst.add(data[i]);
	iter = bst.iterator();
	i=0;
	while (iter.hasNext()) {
	    data[i++] = iter.next();
	}
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

	/* Quick Sort */
	System.out.println("Quicksort:");
	data = clone(randomData);

	startTime = System.currentTimeMillis();
	QuickSort.quickSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tRandom input: " + duration + " ms");

	data = clone(ascendingData);

	startTime = System.currentTimeMillis();
	QuickSort.quickSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tAscending input: " + duration + " ms");

	data = clone(descendingData);

	startTime = System.currentTimeMillis();
	QuickSort.quickSort(data);
	duration = System.currentTimeMillis()-startTime;

	System.out.println("\tDescending input: " + duration + " ms");

    }
}
