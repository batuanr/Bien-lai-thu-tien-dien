package model;

public class Client {
    private String name;
    private String houseNumber;


    public Client() {
    }

    public Client(String name, String houseNumber) {
        this.name = name;
        this.houseNumber = houseNumber;

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



    @Override
    public String toString() {
        return "KhachHang{" +
                "name='" + name + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
