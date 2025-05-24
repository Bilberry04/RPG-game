package core;

public class Equipment {
    private String equipmentName;
    //private String equipmentType;
    //private String equipmentDescription;
    //private int equipmentPrice;
    private int itemLevel;
    private int bonusStrength;
    private int bonusArmor;
    private String imagePath;

    public Equipment(String equipmentName, int bonusStrength, int bonusArmor, int itemLevel) {
        this.equipmentName = equipmentName;
        //this.equipmentType = equipmentType;
        //this.equipmentDescription = equipmentDescription;
        //this.equipmentPrice = equipmentPrice;
        this.bonusStrength = bonusStrength;
        this.bonusArmor = bonusArmor;
        this.itemLevel = itemLevel;
    }


    public int getBonusStrength() { return bonusStrength; }

    public void setBonusStrength(int bonusStrength) { this.bonusStrength = bonusStrength; }

    public int getBonusArmor() { return bonusArmor; }

    public void setBonusArmor(int bonusArmor) { this.bonusArmor = bonusArmor; }

    public String getName() { return equipmentName; }

    public void setName(String name) { this.equipmentName = name; }

    public int getItemLevel() { return itemLevel; }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return equipmentName + " (Lvl " + itemLevel + ", STR+" + bonusStrength + ", ARM+" + bonusArmor + ")";
    }

}
