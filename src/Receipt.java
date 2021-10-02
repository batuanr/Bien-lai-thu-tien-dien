public class Receipt {
    private Client client;

    public Receipt(Client client, int newElectricNumber) {
        this.client = client;
        this.client.getElectricMeter().setNewElectricNumber(newElectricNumber);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public int getBill(){
        int total = (client.getElectricMeter().getNewElectricNumber()
                - client.getElectricMeter().getOldElectricNumber()) * 750;
        client.getElectricMeter().setOldElectricNumber(client.getElectricMeter().getNewElectricNumber());
        return total;
    }

    @Override
    public String toString() {
        return "BienLai{" +
                 client +
                ", Tổng tiền: " + getBill() +
                '}';
    }
}
