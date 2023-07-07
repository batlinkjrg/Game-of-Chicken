package Chicken_Types;

public interface IChicken {
    public String get_name();
    public char get_symbol();
    public void change_direction(int direction);
    public void move();
    public int[] get_location();
    public int attack(int[] enemy_location);
    public void hit(int damage);
    public boolean is_alive();
    public int get_hp();
    public String get_direction();
}
