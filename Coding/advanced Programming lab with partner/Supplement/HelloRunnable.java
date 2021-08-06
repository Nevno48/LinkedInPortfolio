
/**
 * Write a description of class HelloRunnable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}
