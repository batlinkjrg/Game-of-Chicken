package Game_Screen;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private JLabel northText;
    protected NorthPanel () {
        createNorthPanel();
    }

    // Create panel
    protected void createNorthPanel() {
        // Set attributes
        this.setBackground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(720, 55));

        // Create Label to show text on the North panel
        northText = new JLabel(" ", SwingConstants.CENTER);
        northText.setForeground(Color.red);
        northText.setFont(new Font("Ink Free", Font.ITALIC, 32));
        northText.setPreferredSize(new Dimension(720, 50));
        changeNorthText("Welcome to the Game of Chicken");
        this.add(northText);
    }
    
    // For changing the text on this panel
    protected void changeNorthText(String text) {
        northText.setText(text);
    }
}
