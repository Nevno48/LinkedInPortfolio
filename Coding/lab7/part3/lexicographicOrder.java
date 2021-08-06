
/**
 * Write a description of class lexicographicOrder here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class lexicographicOrder
{
    public static void main(String[]args)
    {
        String[] words = {"##$$$", "happy", "Smiles", "Smile", "Happier"};
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                //to ignore case add IgnoreCase at the end of compareTo
                if(words[i].compareTo(words[j]) < 0)
                {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }

        }
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }
    }
}
