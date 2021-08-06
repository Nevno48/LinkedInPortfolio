
/**
 * Write a description of class StringSearch here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class StringSearch
{
    public static void main(String[]args){
        String target = ("Returns the index within this string of the first "+
            "occurance of the specified substring.");
        System.out.println(target.indexOf("the"));
        System.out.println(target.indexOf("first"));
        System.out.println(target.indexOf("second"));
        System.out.println(target.toLowerCase().indexOf("returns"));
    }
}
