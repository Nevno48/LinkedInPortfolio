
/**
 * Write a description of class HelloThread here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}
