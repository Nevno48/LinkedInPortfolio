import java.text.Collator;
import java.util.Locale;
/**
 * Write a description of class frCollator here.
 *
 * @author (Briella Sala & Nick Giordano)
 * @version (Spring 2019)
 */
public class frCollator
{
    public static void main(String[]args)
    {
        Collator frCollator = Collator.getInstance(Locale.FRANCE);
        frCollator.setStrength(Collator.PRIMARY);
        String[] names = {"êtesvous", "fàcil", "facil", "fast", "Où", "ou", "specific", "spécifique"};
        for(int i = 0; i < names.length-1; i++){
            for(int j = i; j < names.length; j++){
                if(frCollator.compare(names[i], names[j]) < 0){
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }

        }
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
    }
}
