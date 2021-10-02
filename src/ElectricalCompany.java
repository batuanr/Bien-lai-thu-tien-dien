import java.util.ArrayList;
import java.util.List;

public class ElectricalCompany {
    List<Client> clientList;
    List<Receipt> receiptList;

    public ElectricalCompany() {
        clientList = new ArrayList<>();
        receiptList = new ArrayList<>();
    }
     public void addClient(Client client) {
        clientList.add(client);
     }
     public void addReceipt(Receipt receipt){
        receiptList.add(receipt);
     }
     public void editClient(String name, Client newClient){
        for (Client client: clientList){
            if (client.getName().equals(name)){
                clientList.remove(client);
                clientList.add(newClient);
            }
        }
     }

    public void getInfo(String code) {
        for (Client client : clientList){
            if (client.getElectricMeter().getCode().equals(code)){
                System.out.println(client);
            }
        }
    }


    public void showReceipt(){
       for (Receipt receipt : receiptList){
           System.out.println(receipt);
       }
    }
}
