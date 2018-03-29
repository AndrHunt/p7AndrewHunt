

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Component for displaying the canvas
 *
 * @author Agatha Owora
 */
public class CanvasPanel extends JPanel {

    private Rectangle2D.Double rect;
    private static final int RECT_WIDTH = 50;
    private static final int RECT_HEIGHT = 90;
    private JTextField TopTitle;
    
    
    


    /**
     * Constructor for the panel
     */
    public CanvasPanel() {
        rect = new Rectangle2D.Double(20, 20, RECT_WIDTH, RECT_HEIGHT);
    }
    

    /**
     * Drawing Method
     *
     * @param g stores the graphics state—the current color, font, and so on
     */
    @Override
    public void paintComponent(Graphics g) {
        
        
        super.paintComponent(g);

        // Draw rectangle
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.fill(rect); // g2.draw( ) draws outline only

        // Draw ellipse
        g2.setColor(Color.RED);
        for (int i = 0; i < 10; i++) {
            g2.draw(new Ellipse2D.Double(100 + i * 10, 100 + i * 10, 60, 30));
        }

        // Draw a string
        g2.setColor(Color.RED);
        g2.setFont(new Font("Courier New", Font.BOLD, 30));
        g2.drawString("A String is drawn", 50, 100);

        // Draw a string
        g2.setColor(Color.GREEN);
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString("Another String", 50, 200);

        // To see when paintComponent is called by JVM
        System.out.println("paintComponet is called");
    }

    /**
     * Moves the rectangle and repaints it The rectangle is moved by multiples
     * of its full width or height
     *
     * @param dx the number of width units
     * @param dy the number of height units
     */
    public void moveRectangle(int dx, int dy) {
        rect.setRect(
                rect.getX() + dx * RECT_WIDTH,
                rect.getY() + dy * RECT_HEIGHT,
                RECT_WIDTH, RECT_HEIGHT);
        repaint();
    }
}
