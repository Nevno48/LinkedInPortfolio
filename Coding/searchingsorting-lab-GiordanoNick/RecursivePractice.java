
/**
 * In this file you get practice writing recursive methods.
 *
 * Zohaib Asif, Nick Giordano
 * 
 */
public class RecursivePractice
{
    // Returns the minimum value in array a from among the values
    // a[first] - a[last]

    public static int minimum(int[] a, int first, int last) {
        int min;
        if (first ==  last - 1){
            return a[first];
        }

        min = minimum(a , first + 1 , last);

        if (a[first] < min)
        {
            return a[first];
        }
        else
        {
            return min;
        }
    }

    // Returns a count of the number of times your lucky number occurs
    // among the values a[first] - a[last]. Implement this one by
    // splitting the problem into two halves and solving each
    // recursively!
    public static int countlucky(int[] a, int lucky, int first, int last) {
        int totalLucky;
        if (first == last - first){
            return 0;
        }

        totalLucky = countlucky(a ,lucky ,first + 1 , last);

        if(a[first] == lucky)
        {
            return totalLucky + 1;
        }
        else if(a[(last - first) + first - 1] == lucky)
        {
            return totalLucky + 1;
        }
        else
        {
            return totalLucky;
        }
    }
    // public static int countlucky(int[] a, int lucky, int first, int last) {
        // int totalLucky;
        // if (first ==  last){
            // return 0;
        // }

        // totalLucky = countlucky(a ,lucky ,first + 1 , last);

        // if (a[first] == lucky)
        // {
            // return totalLucky + 1;
        // }
        // else
        // {
            // return totalLucky;
        // }
    // }

    // Returns true if there is a negative value among the values
    // a[first] - a[last]
    public static boolean negatives(int[] a, int first, int last) {
        boolean negTracker;
        if (first ==  last){
            return false;
        }

        negTracker = negatives(a ,first + 1 , last);

        if(negTracker == true)
        {
            return true;
        }
        if (a[first] >= 0)
        {
            return negTracker;
        }
        else
        {
            return true;
        }
    }

    public static void main(String[] args){
        int [] minTest1 =  {48 , 32 , 3 , 66};
        System.out.println(minimum(minTest1, 0, minTest1.length));

        int [] minTest2 = {-30, 45, 0, -12};
        System.out.println(minimum(minTest2, 0, minTest2.length));

        int [] minTest3 = {-20, 1, 44, -15};
        System.out.println(minimum(minTest3, 1, minTest2.length - 1));

        int[] luckyTest1 = {1, 44, 32, 44, 34, 44};
        System.out.println(countlucky(luckyTest1, 44, 0, luckyTest1.length));

        int[] luckyTest2 = {1, -44, 32, -44, 34, -44};
        System.out.println(countlucky(luckyTest2, -44, 0, luckyTest2.length));

        int[] luckyTest3 = {1, 0, 32, 0, 3, 0};
        System.out.println(countlucky(luckyTest3, 0, 0, luckyTest3.length));

        int [] negTest1 =  {56 , 22 , 1 , 23};
        System.out.println(negatives(negTest1, 0, negTest1.length));

        int [] negTest2 = {56 , 0 , 45 , 23};
        System.out.println(negatives(negTest2, 0, negTest1.length));

        int [] negTest3 = {56 , 22 , 45 , -1};
        System.out.println(negatives(negTest3, 0, negTest1.length));
    }
}
