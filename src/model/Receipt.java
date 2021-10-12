package model;


import java.io.Serializable;
import java.time.LocalDate;

public class Receipt implements Serializable {
    private Client client;
    private ElectricMeter electricMeter;
    private LocalDate dayCreate;

    public Receipt(Client client, ElectricMeter electricMeter, int newElectricNumber) {
        this.client = client;
        this.electricMeter = electricMeter;
        electricMeter.setNewElectricNumber(newElectricNumber);
        dayCreate = LocalDate.now();
    }

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public int getBill(){
        int total = (electricMeter.getNewElectricNumber() - electricMeter.getOldElectricNumber()) * 750;
        return total;
    }

    @Override
    public String toString() {
        return "BienLai{" +
                 client +
                ",  ngày tạo: " + dayCreate +
                ",  oldElectricNumber :" + electricMeter.getOldElectricNumber() +
                ",  newElectricNumber: " + electricMeter.getNewElectricNumber() +
                ", Tổng tiền: " + getBill() +
                '}';
    }
}
