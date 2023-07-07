package Game_Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JPanel {

    protected StartScreen start_screen;
    protected NorthPanel north_Panel;
    protected CenterPanel center_Panel;
    protected SouthPanel south_Panel;
    private ActionListener actionListener, directionListener, resetListener;

    public GameScreen(ActionListener actionListener, ActionListener directionListener, ActionListener resetListener) {
        // Sync variables
        this.actionListener = actionListener;
        this.directionListener = directionListener;
        this.resetListener = resetListener;
        setScreen();

    }

    // Create screen
    private void setScreen(){
        this.setLayout(new BorderLayout());
        this.setSize(1280, 720);

        this.setPreferredSize(new Dimension(1280, 720));
        this.setMaximumSize(new Dimension(1280, 720));
        intializePanels();
    }

    // Create panels
    private void intializePanels() {
        // Create North Panel
        north_Panel = new NorthPanel();
        north_Panel.setSize(720, 200);
        
        this.add(north_Panel, BorderLayout.NORTH);
        north_Panel.setVisible(true);

        // Create Center Panel
        center_Panel = new CenterPanel(9,9);
        this.add(center_Panel, BorderLayout.CENTER);
        center_Panel.setVisible(true);

        // Create South Panel
        south_Panel = new SouthPanel(this.actionListener, this.directionListener, this.resetListener);
        this.add(south_Panel, BorderLayout.SOUTH);
        south_Panel.setVisible(true);
    }      
}
