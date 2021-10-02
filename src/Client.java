public class Client {
    private String name;
    private String houseNumber;
    private ElectricMeter electricMeter;

    public Client() {
    }

    public Client(String name, String houseNumber, ElectricMeter electricMeter) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.electricMeter = electricMeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "name='" + name + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", electricMeter code: " + electricMeter.getCode() +
                '}';
    }
}
