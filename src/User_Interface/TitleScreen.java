package User_Interface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Game_Screen.ButtonsPanel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

public class TitleScreen extends JPanel {
    private ButtonsPanel chickenChoiceButtons, difficutlyButtons;
    private ActionListener chickenChoice, startListener, difficultyListener;
    private Image background;
    private JPanel[][] titlePanel;
    private JLabel titleLabel, nameGrabberLabel;
    private JPanel grabberPanel, nameGrabberPanel;
    private JTextField nameField;
    private JButton startButton;
    private CardLayout cardLayout = new CardLayout();

    public TitleScreen(ActionListener chickenChoice, ActionListener startListener, ActionListener difficultyListener) {
        this.startListener = startListener;
        this.chickenChoice = chickenChoice;
        this.difficultyListener = difficultyListener;
        createTitleScreen();
    }

    private void createTitleScreen() {
        // Set attributes
        setBackground();
        this.setLayout(new GridLayout(5,1));

        // Create components
        createTitleLabel();
        createNameGrabber();
        createButtonPanel();
    }

    // Create Start Button
    private void createButtonPanel() {
        chickenChoiceButtons = new ButtonsPanel(chickenChoice, "Choose Chicken", "Teleporter", "Healer", "Powerful", "Fast");
        chickenChoiceButtons.setVisible(false);
        this.grabberPanel.add(chickenChoiceButtons, "2");

        difficutlyButtons = new ButtonsPanel(difficultyListener, "Set difficulty", "Easy", "Medium", "Hard", "Just Give Up");
        difficutlyButtons.setVisible(false);
        this.grabberPanel.add(difficutlyButtons, "3");
    }

    // Create Title
    private void createTitleLabel() {
        // Create custom grid
        this.titlePanel = new JPanel[5][3];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 1; j++) {
                // set attributes
                this.titlePanel[i][j] = new JPanel();
                this.titlePanel[i][j].setBounds(i*16, j*16, j, i);
                this.titlePanel[i][j].setEnabled(false);
                this.titlePanel[i][j].setBackground(new Color(0, 0, 0, 0));
                this.add(titlePanel[i][j]);
            }
        }

        // Create Title Label
        this.titleLabel = new JLabel("🐔 Game of Chicken 🐔");
        this.titleLabel.setFont(new Font("New Times Roman", Font.ITALIC, 72));
        this.titleLabel.setForeground(Color.red);
        this.titlePanel[1][0].add(titleLabel);

        // Prepare name screen and chicken grabber
        this.grabberPanel = new JPanel();
        this.grabberPanel.setBackground(new Color(0, 0, 0, 0));
        this.grabberPanel.setPreferredSize(new Dimension(500, 100));
        this.grabberPanel.setLayout(cardLayout);
        this.titlePanel[3][0].add(grabberPanel);
    }

    // Create Name Grabber
    private void createNameGrabber() {
        // Create Panel
        this.nameGrabberPanel = new JPanel();
        this.nameGrabberPanel.setPreferredSize(new Dimension(200, 100));
        this.nameGrabberPanel.setBackground(new Color(112, 224, 240, 100));
        this.nameGrabberPanel.setBorder(BorderFactory.createSoftBevelBorder(2, Color.cyan, getBackground()));
        this.nameGrabberPanel.setVisible(true);
        this.nameGrabberPanel.setLayout(new BorderLayout(50, 5));
        this.nameGrabberPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));

        // Create Label
        this.nameGrabberLabel = new JLabel("↓ Enter Name ↓", SwingConstants.CENTER);
        this.nameGrabberLabel.setBackground(getBackground());
        this.nameGrabberLabel.setPreferredSize(new Dimension(400, 25));
        this.nameGrabberLabel.setFont(new Font("New Times Roman", Font.BOLD, 25));
        this.nameGrabberPanel.add(nameGrabberLabel, BorderLayout.NORTH);

        // Create Name Feild
        this.nameField = new JTextField();
        this.nameField.setPreferredSize(new Dimension(200, 25));
        this.nameField.setHorizontalAlignment(JTextField.CENTER);
        this.nameGrabberPanel.add(nameField, BorderLayout.CENTER);

        // Create Start Button
        this.startButton = new JButton("Press Start to Begin");
        this.startButton.setBackground(Color.CYAN);
        this.startButton.setForeground(Color.BLUE);
        this.startButton.setPreferredSize(new Dimension(300, 25));
        this.startButton.addActionListener(this.startListener);
        this.startButton.setActionCommand("Start");
        this.nameGrabberPanel.add(this.startButton, BorderLayout.SOUTH);

        this.grabberPanel.add(nameGrabberPanel, "1");
    }

    // Allows switching to chicken choice panel
    protected void switchChickenChoice(boolean switchChickenChoice) {
        if(switchChickenChoice == true) {
            this.nameGrabberPanel.setVisible(false);
            this.difficutlyButtons.setVisible(false);
            this.chickenChoiceButtons.setVisible(true);
            this.grabberPanel.revalidate();
            this.grabberPanel.repaint();
        } else {
            this.nameGrabberPanel.setVisible(true);
            this.difficutlyButtons.setVisible(false);
            this.chickenChoiceButtons.setVisible(false);
            this.grabberPanel.revalidate();
            this.grabberPanel.repaint();
        }
    }

    // Allows switching to difficulty panel
    protected void switchDifficultyPanel(boolean switchDifficultyPanel) {
        if(switchDifficultyPanel == true) {
            this.nameGrabberPanel.setVisible(false);
            this.difficutlyButtons.setVisible(true);
            this.chickenChoiceButtons.setVisible(false);
            this.grabberPanel.revalidate();
            this.grabberPanel.repaint();
        } else {
            this.nameGrabberPanel.setVisible(true);
            this.difficutlyButtons.setVisible(false);
            this.chickenChoiceButtons.setVisible(false);
            this.grabberPanel.revalidate();
            this.grabberPanel.repaint();
        }
    }

    // This will grab the name
    protected String getPlayerName() {
        return this.nameField.getText();
    }

    // Create board to play on
    private void setBackground() {
        try {                
           this.background = ImageIO.read(new File("..\\Images\\GameOfChicken_Backround.jpeg"));
           this.background = this.background.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Can't open backround");
        }
     }
 
    // Draw image on backround
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, this);          
    }
}
