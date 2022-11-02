import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class footwear{

    String name;
    int price;
    String type;
    float height;
    String totalWheel = "-";
    
    footwear(String name,int price,String type,Float height,String totalWheel){
        this.name = name;
        this.price = price;
        this.type = type;
        this.height = height;
        this.totalWheel = totalWheel;   
    }
}

public class  Main{
    static Scanner scanf = new Scanner(System.in);
    static Vector<footwear> cons = new Vector<>();

    public static void main (String[] args) throws Exception{

        while(true){
            displayMenu();
            int op = scanf.nextInt();
            scanf.nextLine();

            switch(op){
                case 1:
                    cls(args);
                    insert();
                    break;
                case 2:
                    cls(args);
                    view();
                    break;
                case 3:
                    cls(args);
                    update();
                    break;
                case 4:
                    cls(args);
                    delete();    
                    break;
                case 5:
                    cls(args);
                    exit();
                    System.exit(0);
                    break;
            }
            System.out.println("\nPress enter to continue .. ");
            scanf.nextLine();
            cls(args);
        }
    }

    // Insert
    public static void insert(){
        String name;
        int price;
        String type;
        float height;
        String totalWheel = "-";
        
        // Input name
        do{
            System.out.print("Footwear name [3 - 25 charcters] : ");
            name = scanf.nextLine();
        }
        while(name.length() < 3 || name.length() > 25);

        // Input Price
        do{
            System.out.print("Footwear price [more than 10000] : ");
            price = scanf.nextInt();
            scanf.nextLine();
        }
        while(price > 10000);

        // Input Type
        int flag = 0;
        do{
            System.out.print("Foot type [Heels / RollerSkate] : ");
            type = scanf.nextLine();

            if(type.compareTo("Heels") == 0 || type.compareTo("RollerSkate") == 0){
                flag = 1;
            }
        }
        while(flag == 0);

        if(type.compareTo("RollerSkate") == 0){
            do{
                System.out.print("Footwear total wheel [2 - 4 inclusive] : ");
                totalWheel = scanf.nextLine();
            }
            while(Integer.parseInt(totalWheel) < 2 || Integer.parseInt(totalWheel) > 4);
            totalWheel = totalWheel + " Wheels";
        }

        // Input Footwear
        do{
            System.out.print("Footwear Height [1.0 - 9.0] : ");
            height = scanf.nextFloat();
            scanf.nextLine();
        }
        while(height < 1.0 || height > 9.0);

        // Add to newNode 
        footwear newNode = new footwear(name, price, type,height,totalWheel);
        cons.add(newNode);
        System.out.println("Foot wear added successfully !!");

    }

    // View
    public static void view(){
        if(cons.isEmpty() == true){
            System.out.println("There are no footwears to display !");
        }
        else{
            System.out.println("+=====================================================================+");
            System.out.println("| No | Name                      | Price    | Height   | Total Wheels |");
            System.out.println("+=====================================================================+");
            
            for(int i = 0; i < cons.size(); i++){
                System.out.printf("| %2d | %-25s | %-8d | %-8.1f | %-12s |\n",i+1,cons.get(i).name,cons.get(i).price,cons.get(i).height,cons.get(i).totalWheel);
            }
            
            System.out.println("+=====================================================================+");
        }
    }

    // update 
    public static void update(){
        int pos;
        String name;
        int price;
        float height;
        String totalWheel = "-";

        if(cons.isEmpty() == true){
            System.out.println("There are no footwear to update !");
        }
        else{
            do{
                System.out.print("Input footwear index to update : ");
                pos = scanf.nextInt();
                scanf.nextLine();
            }
            while(pos > cons.size() || pos < 0);

            do{
                System.out.print("Footwear name [3 - 25 Characters] : ");
                name = scanf.nextLine();
            }
            while(name.length() < 3 || name.length() > 25);

            do{
                System.out.print("Footwear price [more than 10000] : ");
                price = scanf.nextInt();
                scanf.nextLine();
            }
            while(price > 10000);

            do{
                System.out.print("Footwear height [1.0 - 9.0] : ");
                height = scanf.nextFloat();
                scanf.nextLine();
            }
            while(height < 1.0 || height > 9.0);

            if(cons.get(pos-1).type.compareTo("RollerSkate") == 0){
                do{
                    System.out.print("Footwear total wheel [2 -4 inclusice] : ");
                    totalWheel = scanf.nextLine();
                }
                while(Integer.parseInt(totalWheel) < 2 || Integer.parseInt(totalWheel) > 4);
                totalWheel = totalWheel + " Wheels";
            }
            
            // Update data
            pos = pos - 1;
            cons.get(pos).name = name;
            cons.get(pos).price = price;
            cons.get(pos).height = height;
            cons.get(pos).totalWheel = totalWheel;

            System.out.println("\nFootwear updated successfully !!");
        }
    }

    // Delete
    public static void delete(){
        int pos;
        if(cons.isEmpty() == true){
            System.out.println("There are no footwear to delete !");
        }
        else{
            do{
                System.out.print("Input footwear index to delete : ");
                pos = scanf.nextInt();
                scanf.nextLine();
            }
            while(pos < 0 || pos > cons.size());

            cons.remove(pos-1);
            System.out.println("Footwear deleted successfully !!");
        }
    }

    // Display Menu
    public static void displayMenu(){
        System.out.println("Just do it !!");
        System.out.println("=============");
        System.out.println("1 Add Footwear");
        System.out.println("2 View Footwear");
        System.out.println("3 Update Footwear");
        System.out.println("4 Delete Footwear");
        System.out.println("5 Exit");
        System.out.print(" >> ");
    }

    // Clear console
    public static void cls (String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    // exti massage
    static void exit(){
        System.out.println("Thanks for using just do it program !");
    }
}