import java.util.Random;

public class Helm implements Armour{

    Random random = new Random();
    int rarity;
    String slot;
    String mod1;
    String mod2;
    String mod3;
    public Helm(int quality){
        int rarity = quality;
        if(rarity == 3) {
            mod1 = getRandomAttribute();
            mod2 = getRandomAttribute();
            mod3 = getRandomAttribute();
        }
        else if(rarity == 2) {
            mod1 = getRandomAttribute();
            mod2 = getRandomAttribute();
        }
        else if(rarity == 1) {
            mod1 = getRandomAttribute();
        }
    }

    public String getName(){
        int gearSlot = random.nextInt(4);
        if(gearSlot == 0) {
            slot = "Helm";
        }
        else if(gearSlot == 1) {
            slot = "Chest Piece";
        }
        else if(gearSlot == 2) {
            slot = "Gloves";
        }
        else if(gearSlot == 3) {
            slot = "Boots";
        }
        return slot;
    }

    public String getRandomAttribute() {
        int r = random.nextInt(3);
        if(r == 0) return "Strength + 5";
        if(r == 1) return "Intelligence + 5";
        return "Dexterity + 5";
    }

    public String getRarityDescription() {
        if(rarity == 0) return "Common";
        if(rarity == 1) return "Uncommon";
        if(rarity == 2) return "Rare";
        return "Epic";
    }
    public String getDescription() {
        String descript = getRarityDescription() + " " + slot + ":\n";
        if(rarity == 3) {
            descript = descript + mod1 + "\n";
            descript = descript + mod2 + "\n";
            descript = descript + mod3 + "\n";
        }
        if(rarity == 2) {
            descript = descript + mod1 + "\n";
            descript = descript + mod2 + "\n";
        }
        if(rarity == 1) {
            descript = descript + mod1 + "\n";
        }
        return descript;
    }
}
