package controller;

import io.IO;
import model.Client;
import model.ElectricMeter;
import model.Receipt;

import java.util.ArrayList;
import java.util.List;


public class ElectricalCompany {
    List<Client> clientList;
    List<Receipt> receiptList;
    List<ElectricMeter> electricMeterList;
    private static final String ReceiptFile = "test.dat";

    public ElectricalCompany() {
        clientList = new ArrayList<>();
        receiptList = new ArrayList<>();
        electricMeterList = new ArrayList<>();


    }

    public List<ElectricMeter> getElectricMeterList() {
        return electricMeterList;
    }

    public void setElectricMeterList(ArrayList<ElectricMeter> electricMeterList) {
        this.electricMeterList = electricMeterList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }
    public  void addElectricMeter(ElectricMeter electricMeter){
        electricMeterList.add(electricMeter);
    }

    public void addClient(Client client) {
        clientList.add(client);
    }
    public void addReceipt(Receipt receipt) throws Exception{
        if(receipt.getElectricMeter().getOldElectricNumber() == receipt.getElectricMeter().getNewElectricNumber()){
            throw new Exception("Hóa đơn đã xuất");
        }
        else{
            receiptList.add(receipt);
//            IO.writeFile(ReceiptFile, receiptList);
        }
    }
    public void editClient(String name, Client newClient){
        for (Receipt receipt: receiptList){
            if (receipt.getClient().getName().equals(name)){
               receipt.setClient(newClient);
            }
        }
    }
    public  void showAllClient(){
        for (Client client: clientList){
            System.out.println(client);
        }
    }
    public void showAllElectricMeter(){
        for (ElectricMeter electricMeter: electricMeterList){
            System.out.println(electricMeter);
        }
    }

    public void getInfoClient(String name) {
        for (Client client: clientList){
            if (client.getName().equals(name)){
                System.out.println(client);
            }
        }
    }


//   public List<Receipt> showReceipt(){
//        receiptList.clear();
//        receiptList = (List<Receipt>) IO.readToFile(ReceiptFile);
//        return  receiptList;
//
//    }
}
