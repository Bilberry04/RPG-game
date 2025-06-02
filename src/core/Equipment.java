package core;

public class Equipment {
    private String equipmentName;
    private int itemLevel;
    private int bonusStrength;
    private int bonusArmor;
    private String imagePath;
    private String type;

    public Equipment(String equipmentName, int bonusStrength, int bonusArmor, int itemLevel, String type) {
        this.equipmentName = equipmentName;
        this.bonusStrength = bonusStrength;
        this.bonusArmor = bonusArmor;
        this.itemLevel = itemLevel;
        this.type = type;
    }

    public Equipment() {}


    public int getBonusStrength() { return bonusStrength; }
    public void setBonusStrength(int bonusStrength) { this.bonusStrength = bonusStrength; }

    public int getBonusArmor() { return bonusArmor; }
    public void setBonusArmor(int bonusArmor) { this.bonusArmor = bonusArmor; }

    public String getName() { return equipmentName; }
    public void setName(String name) { this.equipmentName = name; }

    public int getItemLevel() { return itemLevel; }
    public void setItemLevel(int itemLevel) { this.itemLevel = itemLevel; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return equipmentName + " (Lvl " + itemLevel + ", STR+" + bonusStrength + ", ARM+" + bonusArmor + ")";
    }

}
