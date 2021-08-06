/**
Sample methods for binary search: one for int values only,
one that uses Comparable Object references.

@author Jim Teresco, jteresco@mtholyoke.edu, jteresco@siena.edu
Original based on example code by Williams College faculty, used
and extended by Jim Teresco at Williams College, Mount Holyoke
College, The College of Saint Rose, and Siena College

Zohaib Asif, Nick Giordano

 */
import java.util.Random;

public class BinSearch {

    /**
    Binary search on an array of int

    @param a the input array
    @param val int to find in the array
    @pre a is sorted in ascending order
    @return index of val in a, or -1 if not found
     */
    public static int search (int[] a, int val) {
        return binsearch(a, 0, a.length-1, val);
    }

    /**
    Helper method to support additional parameters needed by
    the recursive binary search on array of int

    @param a the entire input array
    @param low lowest index where val may be found
    @param high highest index where val may be found
    @param val int to find in the array
    @return index of val in a, or -1 if not found
     */
    protected static int binsearch(int[] a, int low, int high, int val) {

        // is there still a range where we need to search?
        if (low <= high) {

            // compute the middle location of the range, where we
            // will look for our element
            int mid = (low + high) / 2;

            if (val < a[mid]) {
                // val is smaller than the element at the midpoint,
                // so it could only be found in the first half.
                // The following recursive call looks exactly there:
                // from the bottom of our search range up to but
                // not including the midpoint position (which we know
                // doesn't contain val)
                return binsearch(a, low, mid - 1, val);
            }
            else if (a[mid] < val) {
                // Same idea: val is larger than the midpoint, so it
                // could only be in second half, so we make an
                // appropriate recursive call
                return binsearch(a, mid + 1, high, val);
            }
            else {
                // it wasn't too small, and it wasn't too big, so
                // we found val at a[mid]!  Return the index.
                return mid;
            }
        }
        else {
            // there's no range left to search, so report that
            // we didn't find val by returning -1
            return -1;
        }
    }

    /**
    Binary search on an array of Comparable objects

    @param a the input array
    @param val the Comparable value to find in the array
    @pre all elements in a and val must implement Comparable
    @pre a is sorted in ascending order
    @return index of val in a, or -1 if not found
     */
    public static <T extends Comparable> int search (T[] a, T val) {
        return binsearch(a, 0, a.length -1, val);
    }

    /**
    Helper method for binary search on array of Comparables

    @param a the entire input array
    @param low lowest index where val may be found
    @param high highest index where val may be found
    @param val Comparable element to find in the array
    @return index of val in a, or -1 if not found
     */
    protected static <T extends Comparable> int binsearch(T[] a, int low, int high, T val) {

        if (low <= high) {
            // there is still a range of indices to search
            int mid = (low + high) / 2;
            if (val.compareTo(a[mid]) < 0) {
                // value at midpoint too large, search first half
                return binsearch(a, low, mid - 1, val);
            }
            else if (a[mid].compareTo(val) < 0) {
                // value at midpoint too small, search second half
                return binsearch(a, mid + 1, high, val);
            }
            else {
                // it's at the midpoint
                return mid;
            }
        }
        else {
            // the search range has no elements, so val can't be here
            return -1;
        }
    }

    /**
    Example usage of the binary search methods
     */
    public static void main(String[] args) {
        Random r = new Random();
        final int NUM_INTS = 100;
        final int MAX_INCREMENT = 10;
        int[] orderedInts = new int[NUM_INTS];
        Integer[] orderedIntegers = new Integer[NUM_INTS];
        
        Ratio R1 = new Ratio (1,4);
        Ratio R2 = new Ratio (1,2);
        Ratio R3 = new Ratio (1,1);
        
        Ratio[] ratioArray = {R1, R2, R3};
        
        Ratio R4 = new Ratio (2,16);
        Ratio R5 = new Ratio (2,8);
        Ratio R6 = new Ratio (2,4);
        Ratio R7 = new Ratio (2,2);
        
        Ratio[] ratioArray2 = {R4, R5, R6, R7};
         System.out.println("Test 1: ");
        for (int i = 0; i < ratioArray.length - 1; i++){
            System.out.println(ratioArray[i].compareTo(ratioArray[i + 1]));
        }
         System.out.println("Test 2: ");
        for (int i = 0; i < ratioArray2.length - 1; i++){
            System.out.println(ratioArray2[i].compareTo(ratioArray2[i + 1]));
        }

        // we'll put some random but ascending numbers into our arrays
        int val = r.nextInt(MAX_INCREMENT) + 1;
        orderedInts[0] = val;
        orderedIntegers[0] = val;  // will be autoboxed

        for (int i = 1; i < NUM_INTS; i++) {
            val = orderedInts[i-1] + r.nextInt(MAX_INCREMENT) + 1;
            orderedInts[i] = val;
            orderedIntegers[i] = val;
        }

        // print it
        System.out.println("Array to search:");
        for (int n : orderedInts) {
            System.out.print(n + " ");
        }
        System.out.println();

        // let's see which multiples of half the increment are here
        // so we should have some matches and some not -- note 
        // we know the first will be a search for a value (0) which
        // is smaller than all in the array, and the last will be
        // larger than the last (largest) value
        for (int i = 0; 
        i <= orderedInts[NUM_INTS-1] + MAX_INCREMENT;
        i += MAX_INCREMENT/2) {
            System.out.println("Searching for " + i + ": int array: " + 
                search(orderedInts, i) + ", Integer array: " + 
                search(orderedIntegers, i));
        }

        // the great thing is that we can create arrays of other kinds
        // as well, as long as they're Comparables

        // note these elements will each be autoboxed from double to Double
        Double[] orderedDoubles = { -10.5, -6.0, 0.0, 3.5, 9.1, 17.23 };
        System.out.println("Search for Double values, array to search:");
        for (double n : orderedDoubles) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Search for -5.0: " + search(orderedDoubles, -5.0));
        System.out.println("Search for 0.0: " + search(orderedDoubles, 0.0));
        System.out.println("Search for 5.0: " + search(orderedDoubles, 5.0));
        System.out.println("Search for 9.1: " + search(orderedDoubles, 9.1));

        // and Strings work too
        String[] orderedStrings = {
                "Alice", "Bob", "Carol", "David", "Ellen", "Frank", "Gloria",
                "Hal", "Isabelle", "Joey", "Kimberly", "Larry" };
        System.out.println("Search for String values, array to search:");
        for (String s : orderedStrings) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Search for Abby: " + search(orderedStrings, "Abby"));
        System.out.println("Search for Carol: " + search(orderedStrings, "Carol"));
        System.out.println("Search for Joey: " + search(orderedStrings, "Joey"));
        System.out.println("Search for Zachary: " + search(orderedStrings, "Zachary"));
    }
}
