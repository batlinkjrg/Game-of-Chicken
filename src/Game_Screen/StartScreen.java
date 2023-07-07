package Game_Screen;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
    private JButton startButton;
    private JTextField nameFeild;
    
    protected StartScreen() {
        startPanel();
    }

    private void startPanel() {
        // Add attributes
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);

        // Create the text feild 
        nameFeild = new JTextField(10);
        this.setBackground(Color.LIGHT_GRAY);
        nameFeild.setBorder(BorderFactory.createEmptyBorder(400, 500, 400, 500));
        this.add(nameFeild, BorderLayout.CENTER);

        // Create JButton
    }
}
