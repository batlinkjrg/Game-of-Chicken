package Chicken_Types;

import java.util.Random;

public class powerChicken extends offChicken {
    private int damage;

    // Method to Initiate Chicken
    public powerChicken (String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction) {
        super(name, hp, x_coord, y_coord, max_rows, max_columns, damage+5, direction);
        this.damage = damage+5;
    }

    public powerChicken () {
        super();
    }

    // Special Move
    public void specialMove(Chicken enemy) {
        // Attack the square in front of you and the next one and return to where you started
        super.move();
        super.move();
        enemy.hit(super.attack(enemy.get_location()));
        
        // Attack move back correct direction
        switch (super.get_direction()) {
            case "North":
                super.change_direction(3);
                super.move();
                super.move();
                super.change_direction(1);
                break;
            case "East":
                super.change_direction(4);
                super.move();
                super.move();
                super.change_direction(2);
                break;
            case "South":
                super.change_direction(1);
                super.move();
                super.move();
                super.change_direction(3);
                break;
            case "West": 
                super.change_direction(2);
                super.move();
                super.move();
                super.change_direction(4);
                break;
        }
    }

    // Get chicken type
    @Override
    public String getChickenType() {
        return "Power";
    }
}
