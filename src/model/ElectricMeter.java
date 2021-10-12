package model;

public class ElectricMeter {
    private String code;
    private int oldElectricNumber;
    private int newElectricNumber = 0;

    public ElectricMeter() {
    }

    public ElectricMeter(String code, int oldElectricNumber) {
        this.code = code;
        this.oldElectricNumber = oldElectricNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOldElectricNumber() {
        return oldElectricNumber;
    }

    public void setOldElectricNumber(int oldElectricNumber) {
        this.oldElectricNumber = oldElectricNumber;
    }

    public int getNewElectricNumber() {
        return newElectricNumber;
    }

    public void setNewElectricNumber(int newElectricNumber) {
        this.newElectricNumber = newElectricNumber;
    }

    @Override
    public String toString() {
        return "ElectricMeter{" +
                "code='" + code + '\'' +
                ", oldElectricNumber=" + oldElectricNumber;
    }
}
