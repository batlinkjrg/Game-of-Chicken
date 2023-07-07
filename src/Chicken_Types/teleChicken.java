package Chicken_Types;

public class teleChicken extends defChicken {
    // Method to Initiate Chicken
    public teleChicken (String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction) {
        super(name, hp, x_coord, y_coord, max_rows, max_columns, damage, direction);
    }
    
    // Defualt fastChicken
    public teleChicken() {
        super();
     }
    
    // Teleport Ablilty
    public void specialMove(Chicken enemy) {
        // Move 5 times as far in one turn
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
    }
            // Get chicken type
    @Override
    public String getChickenType() {
        return "Teleporter";
    }
}
