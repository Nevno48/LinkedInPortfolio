import java.util.Scanner;
import java.util.*;
/**
 * Write a description of class Equality here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class Equality
{
    public static void main(String[]args)
    {
        System.out.println("Primate".equalsIgnoreCase("private".intern()));
        System.out.println("Polish".equalsIgnoreCase("polish".intern()));
        System.out.println("Closer".equalsIgnoreCase("CLOSER".intern()));
    }
}
