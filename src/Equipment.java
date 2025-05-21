public class Equipment {
    private String name;
    //private String equipmentType;
    //private String equipmentDescription;
    //private int equipmentPrice;
    private int itemLevel;
    private int bonusStrength;
    private int bonusArmor;
    public Equipment(String equipmentName, int bonusStrength, int bonusArmor, int itemLevel) {
        this.name = name;
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

    public String getName() { return name; }

    public int getItemLevel() { return itemLevel; }
}
