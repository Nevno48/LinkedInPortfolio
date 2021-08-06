
/**
 * Write a description of class myStringFunctions here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class myStringFunctions
{
public static int strLength(String str)
{
    if(str.equals(""))
    {
        return 0;
    }
    else
    {
        str = str.substring(0, str.length() - 1);
        return strLength(str) + 1;
    }
}

public static String reverse(String str)
{
    if(str.length() == 1)
    {
        return str;
    }
    else
    {
        str = str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1)) ;
        return str;
    }
}

public static String compact(String str)
{
    if(str.length() == 0)
    {
        return str;
    }
    else if(str.contains(" "))
    {
        str = str.replace(" ", "");
        return str;
    }
    else
    {
        str = str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1)) ;
        return str;
    }
}

public static void main(String args[])
{
    String word = "word";
    System.out.println(strLength(word));
    System.out.println(reverse(word));
    word = "alphabet soup";
    System.out.println(strLength(word));
    System.out.println(reverse(word));
    System.out.println(compact(word));
    word = "Grettings to all!";
    System.out.println(strLength(word));
    System.out.println(reverse(word));
    System.out.println(compact(word));
}
}
