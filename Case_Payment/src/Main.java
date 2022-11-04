import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


class customer{
    String name;
    String gender;
    int jumlahTiket;
    int sumPayment;
    String payStatus;
    String id;

    customer(String name, String gender, int jumlahTiket,int sumPayment , String payStatus,String id){
        this.name = name;
        this.gender = gender;
        this.jumlahTiket = jumlahTiket;
        this.sumPayment = sumPayment;
        this.payStatus = payStatus;
        this.id = id;
    }
}

public class Main {
    static Vector<customer> newCustomer = new Vector<>();
    static Scanner scanf = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) throws IOException, InterruptedException{

        while(true){
            menu();
            switch(op()){
                case 1:
                    cls(args);
                    addPembelian();
                    break;
                case 2:
                    cls(args);
                    update();
                    break;
                case 3:
                    cls(args);
                    cancle();
                    break;
                case 4:
                    cls(args);
                    view();
                    break;
                case 5:
                    break;
            }
            System.out.println("Press (ENTER) back to menu .. ");
            scanf.nextLine();
            cls(args);
        }
    }

    // add pembelian 
    public static void addPembelian(){
        String name;
        String gender;
        int jumlahTiket;
        int sumPayment;
        String status = "Waiting Payment";
        String id;

        // insert
        System.out.print("Masukan nama : ");
        name = scanf.nextLine();

        System.out.print("Masukan Gender : ");
        gender = scanf.nextLine();

        System.out.print("Masukan Jumlah tiket : ");
        jumlahTiket = scanf.nextInt();
        scanf.nextLine();

        // setelah insert menampilkan
        id = generateId();
        System.out.println("ID : " + id);

        sumPayment = jumlahTiket * 500000;
        System.out.println("Jumlah pembayaran : " + sumPayment);

        System.out.println("Status payment : " + status);        

        // ini masukin ke node Vector
        customer customer = new customer(name, gender, jumlahTiket, sumPayment, status,id);
        newCustomer.add(customer);
    }


    // Display menu
    public static void menu(){
        System.out.println("Wellcome");
        System.out.println("========");
        System.out.println("1. Add pembelian");
        System.out.println("2. Update Status Pembayaran");
        System.out.println("3. Pembatalan Pembayaran");
        System.out.println("4. Laporan Pembelian");
        System.out.println("5. Exit");
        System.out.print(" >> ");
    }

    // Update
    public static void update(){
        view();

        int flag = 0;

        System.out.print("Masukan id yang ingin di update : ");
        String searchId = scanf.nextLine();

        for(int i = 0; i < newCustomer.size(); i++){
            if(newCustomer.get(i).id.compareTo(searchId) == 0){
                newCustomer.get(i).payStatus = "Success Payment";
                flag = 1;
            }
        }

        if(flag == 1){
            System.out.println("successfully updated !");
        }
        else{
            System.out.println("Data nga ketemu !");
        }
    }

    // Pembatanlan pembelian
    public static void cancle(){
        view();
        
        System.out.print("Masukan id yang ingin di cancel : ");
        String searchId = scanf.nextLine();

        int flag = 0;
        for(int i = 0; i < newCustomer.size(); i++){
            if(newCustomer.get(i).id.compareTo(searchId) == 0 ){
                flag = 1;
                newCustomer.remove(i);
            }
        }

        if(flag == 1){
            System.out.println("deleted !");
        }
        else{
            System.out.println("Data nga ketemu buat di delete !");
        }
    }

    //  Laporan pembelian
    public static void view(){
        System.out.println("+===========================================================================================+");
        System.out.println("| ID    | Name          | Gender     | Jumlah Tiket  | Total Pembayaran | Status Pembayaran |");
        System.out.println("+===========================================================================================+");

        for(int i = 0; i < newCustomer.size(); i++){
            System.out.printf("| %s | %-13s | %-10s | %-13d | %-16d | %-17s |\n",newCustomer.get(i).id,newCustomer.get(i).name,newCustomer.get(i).gender,newCustomer.get(i).jumlahTiket,newCustomer.get(i).sumPayment,newCustomer.get(i).payStatus);
        }

        System.out.println("+===========================================================================================+");
    }

    // Option
    public static int op(){
        int op = scanf.nextInt();
        scanf.nextLine();
        return op;
    }

    // Clear console
    public static void cls (String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    // Generate Id
    public static String generateId(){
        String idChar = "QWERTYUIOPASDFGHJKLZXCVBNM";
        int resultRandom = random.nextInt(26-0) + 0;
        String id = String.valueOf(idChar.charAt(resultRandom));
        
        for(int i = 0; i < 4; i++){
            resultRandom = random.nextInt(26-0) + 0;
            id = id + String.valueOf(idChar.charAt(resultRandom));
        }

        return id;
    }
    
}
