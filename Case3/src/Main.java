import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
class footwear{

    String name;
    int price;
    String type;
    float height;
    int totalWheel;
    
    footwear(String name,int price,String type,Float height,int totalWheel){
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

        if(cons == null){
            System.out.println("tets");
        }

        while(true){
            displayMenu();
            int op = scanf.nextInt();

            switch(op){
                case 1:
                    cls(args);
                    insert();
                    break;
                case 2:
                    System.out.println("opp2");
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    // Insert
    public static void insert(){
        String name;
        int price;
        String type;
        float height;
        int totalWheel = 0;
        
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
        }
        while(price > 10000);

        // Input Type
        do{
            System.out.print("Foot type [Heels / RollerSkate] : ");
            type = scanf.nextLine();
        }
        while(type.compareTo("Heels") != 0 || type.compareTo("RollerSkate") != 0);

        if(type.compareTo("RollerSkate") == 0){
            do{
                System.out.print("Footwear total wheel [2 - 4 inclusive] : ");
                totalWheel = scanf.nextInt();
            }
            while(totalWheel < 2 || totalWheel > 4);
        }

        // Input Footwear
        do{
            System.out.print("Footwear Height [1.0 - 9.0] : ");
            height = scanf.nextFloat();
        }
        while(height < 1.0 || height > 9.0);

        // Add to newNode 
        footwear newNode = new footwear(name, price, type,height,totalWheel);
        cons.add(newNode);
        System.out.println("Foot wear added successfully !!");

    }

    // update 
    public static void update(){
        int pos;
        String name;
        int price;
        float height;
        int totalWheel = 0;

        if(cons.isEmpty() == true){
            System.out.println("There are no footwear to update !");
        }
        else{
            do{
                System.out.print("Input footwear index to update : ");
                pos = scanf.nextInt();
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
            }
            while(price > 10000);

            do{
                System.out.println("Footwear height [1.0 - 9.0] : ");
                height = scanf.nextFloat();
            }
            while(height < 1.0 || height > 9.0);

            if(cons.get(pos).type.compareTo("RollerSkate") == 0){
                do{
                    System.out.print("Footwear total wheel [2 -4 inclusice] : ");
                    totalWheel = scanf.nextInt();
                }
                while(totalWheel < 2 || totalWheel > 4);
            }
            
            cons.get(pos).name = name;
            cons.get(pos).price = price;
            cons.get(pos).height = height;
            cons.get(pos).totalWheel = totalWheel;
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
}
