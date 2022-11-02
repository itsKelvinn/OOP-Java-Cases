import java.util.Scanner;

public class test {
    static Scanner scanf = new Scanner(System.in);
    static String nama;
    public static void main(String[] args){
        insert();
        System.out.println("Nama saya adalah: " + nama.length());
    }

    public static void insert(){
        do{
            System.out.print("Masukan nama: ");
            nama = scanf.nextLine();
        }
        while(nama.length() > 10 || nama.length() < 5);
    }
}
