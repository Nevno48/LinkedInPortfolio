import java.util.Scanner;
/**
 * Write a description of class InverseCase here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class InverseCase
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuffer word = new StringBuffer(input);
        for(int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt(i);
            if(Character.isLowerCase(word.charAt(i)) == true)
            {
                word.setCharAt(i,Character.toUpperCase(letter));
            }
            else
            {
                word.setCharAt(i,Character.toLowerCase(letter));
            }
        }
        System.out.println(word);
    }
}
