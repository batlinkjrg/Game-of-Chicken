package Game_Screen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class CenterPanel extends JPanel {
    private JButton[][] board;
    private int rows, columns;
    private Image background;

    protected CenterPanel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new JButton[this.rows][this.columns];
        createPanel();
    }

    // Create panel
    private void createPanel() {
        // Set attributes
        this.setBackground(Color.BLACK);
        setBackground();
        this.setBorder(BorderFactory.createEmptyBorder(10, 340, 10, 340));
        this.setLayout(new GridLayout(0, this.columns));

        // Create Board
        initializeBoard();
    }

    // Create board to play on
    private void initializeBoard() {
        // Create Grid
        boolean colorPicker = true;
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                // set attributes and create buttons
                this.board[i][j] = new JButton();
                this.board[i][j].setBounds(i*16, j*16, j, i);
                this.board[i][j].setEnabled(false);
                this.board[i][j].setBorder(new LineBorder(Color.BLACK));
                this.add(board[i][j]);

                // This will alternate squares setting colors
                if(colorPicker) {
                    this.board[i][j].setBackground(new Color(112, 224, 240));
                } else {
                    this.board[i][j].setBackground(new Color(116, 232,228));
                }
                colorPicker = !colorPicker;
            }
        }
    }

    // Used to mark the board where the players are
    protected void mark_board(int y, int x, Icon icon) {
        this.board[y-1][x-1].setIcon(icon);
    }

    // Create backround
    private void setBackground() {
        try {                
           this.background = ImageIO.read(new File("src\\Images\\GameOfChicken_Backround.jpeg"));
           this.background = this.background.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Can't open backround");
        }
     }
 
    // Draw backround
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, this);          
    }
}
