//Explanation: My code uses the factory design pattern with which it creates Armour objects of int quality.
// Had I more time I would have used the decorator pattern to work with attributes such as strength, intelligence,
// etc., in which one can virtually have an infinite value. The factory design principle's use is justified because
// many different kinds of armours can be brought into the game and for such a scenario, the factory principle suits right.


public interface ArmourFactory {
    public Armour spawnArmour(int quality);
}