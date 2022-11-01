import java.util.Scanner;

public class App {
    static Scanner scanf = new Scanner(System.in);
    static String nameHolder;

    public static void main(String[] args) throws Exception {
        inputname();
        while(true){
            switch(displayMenu()){
                case 1:
                    System.out.println("Full Rectangle Shape");
                    break;
                case 2:
                    System.out.println("Empty Rectangle Shape");
                    break;
                case 3:
                    System.out.println("Right Triangle Shape");
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
            }
        }

    }

    // Input name
    public static void inputname(){
        String name;
        do{
            System.out.print("Welcome, please input your name [5-25 chars] : ");
            name = scanf.nextLine();
        }while(name.length() < 5 || name.length() > 25);
        nameHolder = name;
    }

    // Menu Display
    public static Integer displayMenu(){
        System.out.println("Wellcome " + nameHolder);
        System.out.println("Shape Printer");
        System.out.println("=============");
        System.out.println("1. Full Rectangle Shape");
        System.out.println("2. Empty Rectangle Shape");
        System.out.println("3. Right Triangle Shape");
        System.out.println("4. Exit");
        System.out.print("Choose >> ");
        int op = scanf.nextInt();
        return op;
    }

    // Rectangle Shape
    public static void RectangleShape(){
        int size;
        do{
            System.out.print("Input Full Rectangle Size [greater than 1] : ");
            size = scanf.nextInt();
        }
        while(size > 1);
    }


}
