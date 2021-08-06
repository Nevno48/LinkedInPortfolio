import java.util.*;
/**
 *  Demonstrates the functionality of the built-in Locale class 
 * 
 * @author Darren Lim 
 * @version 1.0
 */
public class LocaleTest
{
    public static void main(String args[])
    {
        Locale rightHere = Locale.getDefault();
        System.out.println(rightHere.getDisplayName());
    }
}
