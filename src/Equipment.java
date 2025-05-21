public class Equipment {
    private String equipmentName;
    //private String equipmentType;
    //private String equipmentDescription;
    //private int equipmentPrice;
    private int bonusStrength;
    private int bonusArmor;
    public Equipment(String equipmentName, int bonusStrength, int bonusArmor) {
        this.equipmentName = equipmentName;
        //this.equipmentType = equipmentType;
        //this.equipmentDescription = equipmentDescription;
        //this.equipmentPrice = equipmentPrice;
        this.bonusStrength = bonusStrength;
        this.bonusArmor = bonusArmor;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public int getBonusArmor() {
        return bonusArmor;
    }

    public void setBonusArmor(int bonusArmor) {
        this.bonusArmor = bonusArmor;
    }
}
