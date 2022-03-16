public class ArmourSpawner implements ArmourFactory{
    public Armour spawnArmour(int quality) {
        Helm helm = new Helm(quality);
        return helm;
    }
}
