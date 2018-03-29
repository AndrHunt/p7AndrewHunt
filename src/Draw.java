
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Draw extends JFrame {

    private final JLabel text;
    private final CanvasPanel canvas;
    private final JPanel buttonPanel;
    private final JButton[] b = new JButton[12];

    /**
     * Constructor for the drawing canvas
     */
    public Draw() {
        text = new JLabel("Play Ball!!!");
        text.setFont(new Font("Courier New", Font.BOLD, 18));

        canvas = new CanvasPanel();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new java.awt.GridLayout(3, 4));
        ButtonObserver observer = new ButtonObserver();
        for (int i = 0; i < b.length; i++) {
            if (i == 10) {
                b[i] = new JButton("New Game");
                b[i].setEnabled(true);
            } else if (i == 11) {
                b[i] = new JButton("Clear");
                b[i].setEnabled(false);
            } else {
                b[i] = new JButton("" + i);
                b[i].setEnabled(false);
            }

            buttonPanel.add(b[i]);
            b[i].addActionListener(observer);
        }

        // ContentPane's default layout manager: BorderLayout       
        Container contentPane = getContentPane();
        contentPane.add(text, "North");
        contentPane.add(canvas, "Center");
        contentPane.add(buttonPanel, "South");
    }

    // Adding an event to the button pressed
    private class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            for (int i = 0; i < b.length; i++) {
                if (source == b[10]) {
                    for (int l = 0; l < 10; l++) {
                        b[l].setEnabled(true);
                    }
                } else if (source == b[11]) {
                    
                }
            }

        }

    }
}
