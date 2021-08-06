import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseWheelEvent;

/**
 * A demonstration of KeyListener
 *
 * @author Darren Lim
 * @version 1.0
 */
public class KeyboardPanel extends JPanel implements KeyListener, MouseListener, MouseWheelListener
{

    int width, height;
    int x, y;
    String s = "";
    boolean scroll;
    /**
     * Constructor for objects of class KeyboardPanel
     */
    public KeyboardPanel()
    {
        super();
        setPreferredSize(new Dimension(500, 500));
        setOpaque(true);
        width = getPreferredSize().width;
        height = getPreferredSize().height;
        setBackground( Color.BLACK );
        setFocusable(true);

        x = width/2;
        y = height/2;

        addKeyListener( this );
        addMouseListener( this );
        addMouseWheelListener( this );
    }

    public void mouseWheelMoved( MouseWheelEvent e){
        this.scroll = false;
        if (e.getWheelRotation() != 0) {
            this.scroll = true;
        }
        repaint();
    }

    public void keyPressed( KeyEvent e ) { }

    public void keyReleased( KeyEvent e ) { }

    public void keyTyped( KeyEvent e ) {
        char c = e.getKeyChar();
        if ( c != KeyEvent.CHAR_UNDEFINED ) {
            s = s + c;
            repaint();
            e.consume();
        }
    }

    public void mouseEntered( MouseEvent e ) { }

    public void mouseExited( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    public void mouseClicked( MouseEvent e ) {
        x = e.getX();
        y = e.getY();
        s = "";
        repaint();
        e.consume();
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        if(scroll == true)
        {
            g.setColor( Color.BLACK );
            g.drawRect(0,0,getWidth(), getHeight());
            scroll = false;
        }
        else
        {

            g.setColor( Color.gray );
            g.drawLine( x, y, x, y-10 );
            g.drawLine( x, y, x+10, y );
            g.setColor( Color.green );
            g.drawString( s, x, y );
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Mouse Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        KeyboardPanel panel = new KeyboardPanel();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main (String[] args)
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
