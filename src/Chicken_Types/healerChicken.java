package Chicken_Types;

public class healerChicken extends defChicken {

    // Method to Initiate Chicken
    public healerChicken (String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction) {
        super(name, hp, x_coord, y_coord, max_rows, max_columns, damage, direction);
    }

    public healerChicken () {
        super();
    }

    // Chicken healing ablility
    public void specialMove(Chicken enemy) {
        int healthToHeal = this.get_hp() + 10;
        super.set_hp(healthToHeal);
    }

    // Get chicken type
    @Override
    public String getChickenType() {
        return "Healer";
    }
}
