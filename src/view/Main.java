package view;

import controller.ElectricalCompany;
import model.Client;
import model.ElectricMeter;
import model.Receipt;


import java.util.Scanner;

public class Main {
    static ElectricalCompany electricalCompany = new ElectricalCompany();
    public static void main(String[] args) throws Exception {

        ElectricMeter electricMeter1 = new ElectricMeter("011", 6);
        ElectricMeter electricMeter2 = new ElectricMeter("012", 9);
        ElectricMeter electricMeter3 = new ElectricMeter("013", 2);

        Client client1 = new Client("Tuấn", "19");

        Client client2 = new Client("Hoàng", "69");

        Client client3 = new Client("Quân", "17");


        electricalCompany.addClient(client1);
        electricalCompany.addClient(client2);
        electricalCompany.addClient(client3);

        electricalCompany.addElectricMeter(electricMeter1);
        electricalCompany.addElectricMeter(electricMeter2);
        electricalCompany.addElectricMeter(electricMeter3);



      // test
        Receipt receipt = new Receipt(client1, electricMeter1, 55);
        electricalCompany.addReceipt(receipt);




        while (true){
            int choice;
            Scanner n = new Scanner(System.in);
            System.out.println("Nhập 1: Nhập thông tin khách hàng mới");
            System.out.println("Nhập 2: Thêm đồng hồ điện mới");
            System.out.println("Nhập 3: Sửa thông tin khách hàng");
            System.out.println("Nhập 4: tạo biên lai khách mới");
            System.out.println("Nhập 5: danh sách đồng hồ điện");
            System.out.println("Nhập 6: danh sách người dùng");
            System.out.println("Nhập 7: lấy thông tin 1 khách hàng");
            System.out.println("Nhập 8: xem các biên lại đã nhập");
            System.out.println("Nhập 0: Exit");
            System.out.println("Thank ! ");

            choice = n.nextInt();
            switch (choice){
                case 1:
                    electricalCompany.addClient(getNewClient());
                    break;
                case 2:
                    electricalCompany.addElectricMeter(getNewElectricMeter());
                case 3:
                    editClient();
                    break;
                case 4:
                    electricalCompany.addReceipt(getNewReceipt());
                    break;
                case 5:
                    electricalCompany.showAllElectricMeter();
                    break;
                case 6:
                    electricalCompany.showAllClient();
                case 7:
                    getInfoClient();
                    break;
                case 8:
                    showReceipt();
                    break;
                case 0: return;
                default:
                    System.out.println("no choice");
            }
        }

    }

    private static void showReceipt() {
        for (Receipt receipt1: electricalCompany.getReceiptList()){
            System.out.println(receipt1);
        }
    }

    private static void editClient() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        String name = s.nextLine();
        electricalCompany.editClient(name, getNewClient());
    }

    private static void getInfoClient() {
        Scanner s = new Scanner(System.in);
        String name;
        System.out.println("nhập tên");
        name = s.nextLine();
        electricalCompany.getInfoClient(name);
    }

    public static Client getNewClient(){
        Scanner s = new Scanner(System.in);
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("House Number");
        String houseNumber = s.nextLine();
        return new Client(name, houseNumber);
    }
    public static ElectricMeter getNewElectricMeter(){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("Nhập mã");
        String code = s.nextLine();
        System.out.println("Nhập số điẹn cũ");
        int oldElectricNumber = n.nextInt();
        return new ElectricMeter(code, oldElectricNumber);
    }
    public static Receipt getNewReceipt() {
        Scanner s = new Scanner(System.in);
        ElectricMeter electricMeter = findElectricMeter();
        if(electricMeter.getNewElectricNumber() != 0){
            electricMeter.setOldElectricNumber(electricMeter.getNewElectricNumber());
        }


        System.out.println("Nhập số điện mới");
        int newElectricNumber = s.nextInt();

        return new Receipt(findClient(), electricMeter, newElectricNumber);
    }
    public static Client findClient (){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập name");
        String name = s.nextLine();
        for (Client client: electricalCompany.getClientList()){
            if (client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
    public static ElectricMeter findElectricMeter(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập model.ElectricMeter code");
        String electricMeterCode = s.nextLine();
        for (ElectricMeter electricMeter: electricalCompany.getElectricMeterList()){
            if (electricMeter.getCode().equals(electricMeterCode)){
                return electricMeter;

            }
        }
        return null;
    }
}
