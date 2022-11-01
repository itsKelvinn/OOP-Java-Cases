import java.util.Scanner;

public class App {
    static Scanner scanf = new Scanner(System.in);
    static String nameHolder;

    public static void main(String[] args) throws Exception {
        clear();
        inputname();
        clear();
        while(true){
            switch(displayMenu()){
                case 1:
                    clear();
                    RectangleShape();
                    break;
                case 2:
                    clear();
                    EmptyRectangleShape();
                    break;
                case 3:
                    clear();
                    RightTriangleShape();
                    break;
                case 4:
                    System.exit(0);
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
        System.out.println("\n\nWellcome " + nameHolder);
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
        while(size < 1);

        for(int i = 0; i < size ; i++){
            for(int j = 0 ; j < size; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
    // Empty Rectangle Shape
    public static void EmptyRectangleShape(){
        int size;
        do{
            System.out.print("Input Full Empaty Rectangle Size [greater than 1] : ");
            size = scanf.nextInt();
        }
        while(size < 1);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == 0 || i == size - 1){
                    System.out.print("*");
                }
                else if(j == 0 || j == size - 1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }


    // Right Triangle Shape
    public static void RightTriangleShape(){
        int size;
        do{
            System.out.print("Input Full Empaty Right Triangle Shape Size [greater than 1] : ");
            size = scanf.nextInt();
        }
        while(size < 1);

        for(int i = 0; i < size; i++){
            for(int j = 0; j <= i; j++){
                if(i == 1 || i == 0 || i == size-1){
                    System.out.print("*");
                }
                else if( j == 0 || j == i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

    // For clear Console
    public static void clear(){
        for(int i = 0; i < 30; i++){
            System.out.println("");
        }
    }
}
