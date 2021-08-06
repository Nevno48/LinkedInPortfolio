/*
 * Zohaib Asif, Nick Giordano
 * 
 * Example Ratios -- the Ratio class
 *
 * This class encapsulates a numerator and denominator and
 * includes the capability to set the numerator or denominator,
 * retrieve the numerator or denominator, retrieve the decimal
 * equivalent of the ratio, and return a "pretty" String 
 * representation of the ratio
 *
 * Jim Teresco, The College of Saint Rose, CSC 202, Fall 2012
 * Siena College, CSIS 210, Fall 2016
 */

public class Ratio implements Comparable<Ratio>{

    // We first define the fields -- also called instance variables
    // that define the state of a ratio.

    // In this case, we need only two integers, one each for the numerator
    // and denominator.

    // Note that these look like local variables in a method, except we
    // add the qualifier "private" to indicate that no one except the
    // methods of this class can access these variables.  This is the
    // most common qualifier for instance variables.

    // Instance variables have a class scope -- they are visible inside all
    // methods we write within this class.
    private int numerator;
    private int denominator;

    // We next provide the methods that operate on a Ratio.  The first
    // is usually a special method that gets called when we create a
    // Ratio, called the constructor.  It looks like the method calls
    // we have seen earlier in the semester, except we do not need
    // "static" or "void".  The name of the constructor must match the
    // name of the class, and it should take any parameters needed to
    // give the class its initial value.
    public Ratio(int num, int den) {

        // Inside the constructor, we initialize our instance variables.  In
        // this case, we initialize them based entirely on the parameters.
        // In some other cases, the initialization might be to constant values
        // or may use more complex expressions.  Note that "num" and "den" are
        // parameters whose scope is only this constructor -- they will not 
        // exist when we get to other methods later on.  While "numerator"
        // and "denominator" are instance variables that will remain in scope
        // and retain their values in other methods we call later.

        numerator = num;
        denominator = den;
    }

    // We next provide two "mutator" methods.  These methods are capable of
    // modifying the "private" instance variables based on the values in the
    // parameters.  Mutator methods modify the state of an object, but do
    // not usually return any information, so they are specified with a "void"
    // qualifier in addition to "public".  Note that we do not specify "static"
    // on any of our methods in the class now that we are defining our own
    // classes that represent objects.
    public void setNumerator(int num) {

        numerator = num;
    }

    public void setDenominator(int den) {

        denominator = den;
    }

    // Objects aren't useful if we cannot get information back out from them.
    // This is done with "accessor" methods -- methods that allow us to access
    // the private instance variables within the class describing our object.
    // We start with 2 simple accessors -- ones that allow us to retrieve the
    // numerator and denominator.  Since those are both integer values, we specify
    // "int" return values on our methods.
    public int getNumerator() {

        return numerator;
    }

    public int getDenominator() {

        return denominator;
    }

    // Methods can also compute and return something interesting.  In this case,
    // we add the capability to compute and return the "decimal" equivalent
    // of the ratio.  This will be a double.
    public double getDecimalValue() {

        return 1.0 * numerator / denominator;
    }

    public int compareTo(Ratio other){     
        if (other.getDecimalValue() == this.getDecimalValue()){
        return 0;
       }
       else if (other.getDecimalValue() > this.getDecimalValue()){
        return -1;   
       }
       else {
        return 1;   
       }
    }    // All Java classes provide a mechanism for printing a meaningful
            // representation of each instance of the class.  It is always in a
            // method named toString that returns a String.  If we do not provide
            // such a method, Java will use a builtin one (which will work but
            // which probably does not do quite what we'd like).  So we provide one
            // here to print out our Ratio in a "nice" format.
    public String toString() {

                return numerator + "/" + denominator;
    }

    public static void main(String[] args){
            Ratio R1 = new Ratio(1,2);
            Ratio R2 = new Ratio(2,4);
            System.out.println(R1.compareTo(R2));
            
            Ratio R3 = new Ratio(2,2);
            Ratio R4 = new Ratio(0,5);
            System.out.println(R3.compareTo(R4));
            
            Ratio R5 = new Ratio(4,5);
            Ratio R6 = new Ratio(11,4);
            System.out.println(R5.compareTo(R6));
    }
    }
