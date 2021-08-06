
/**
 * This program uses Thread.sleep to countdown.
 *
 * @author Nick Giordano
 * @version 3/18/19
 */
public class CountDown
{
    public static void main(String args[])
        throws InterruptedException {
        for (int i = 10;
             i > 0;
             i--) {
            //Pause for 1 seconds
            Thread.sleep(1000);
            //Print a message
            System.out.println(i);
        }
        System.out.println("BlastOff!");
    }
}
