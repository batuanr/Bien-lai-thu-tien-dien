import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    static ElectricalCompany electricalCompany = new ElectricalCompany();
    public static void main(String[] args) throws Exception {

        Client client1 = new Client("Tuấn", "19", new ElectricMeter("111", 12));

        Client client2 = new Client("Hoàng", "69", new ElectricMeter("222", 16));

        Client client3 = new Client("Quân", "17", new ElectricMeter("333", 2));


        electricalCompany.addClient(client1);
        electricalCompany.addClient(client2);
        electricalCompany.addClient(client3);


      // test
        Receipt receipt = new Receipt(client1, 55);
        electricalCompany.addReceipt(receipt);




        while (true){
            int choice;
            Scanner s = new Scanner(System.in);
            Scanner n = new Scanner(System.in);
            System.out.println("Nhập 1: Nhập thông tin khách hàng mới");
            System.out.println("Nhập 2: Sửa thông tin khách hàng");
            System.out.println("Nhập 3: tạo biên lai");
            System.out.println("Nhập 4: lấy thông tin 1 khách hàng");
            System.out.println("Nhập 5: xem các biên lại đã nhập");
            System.out.println("Nhập 0: Exit");
            System.out.println("Thank ! ");

            choice = n.nextInt();
            switch (choice){
                case 1:
                    electricalCompany.addClient(getNewClient());
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng");
                    String name = s.nextLine();
                    electricalCompany.editClient(name, getNewClient());
                    break;
                case 3:
                    electricalCompany.addReceipt(getNewReceipt());
                    break;
                case 4:
                    System.out.println("nhập ElectricMeter code");
                    String electricMeterCode = s.nextLine();
                    electricalCompany.getInfo(electricMeterCode);
                    break;
                case 5:
                    electricalCompany.showReceipt();
                    break;
                case 0: return;
                default:
                    System.out.println("no choice");
            }
        }

    }
    public static Client getNewClient(){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("House Number");
        String houseNumber = s.nextLine();
        System.out.println("ElectricMeter code");
        String electricMeterCode = s.nextLine();
        System.out.println("oldElectricNumber");
        int oldElectricNumber = n.nextInt();
        return new Client(name, houseNumber,
                new ElectricMeter(electricMeterCode, oldElectricNumber));
    }
    public static Receipt getNewReceipt() throws Exception{
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("Nhập ElectricMeter code");
        String electricMeterCode = s.nextLine();
        System.out.println("Nhập số điện mới");
        int newElectricNumber = n.nextInt();
        for (Client client: electricalCompany.clientList){
            if (client.getElectricMeter().getCode().equals(electricMeterCode)){
                 return new Receipt(client, newElectricNumber);
            }

        }
        throw new UnsupportedOperationException("tên không đúng");
    }
}
