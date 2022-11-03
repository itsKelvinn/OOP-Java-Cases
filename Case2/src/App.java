import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class student{
    final String name;
    final int age;
    protected ArrayList<Float> gpa = new ArrayList<>();

    student(String name, int age, float gpa){
        this.name = name;
        this.age = age;
        this.gpa.add(gpa);
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void getGpa(){
        for(int i = 0; i < gpa.size(); i++){
            if(i == 0){
                System.out.print(gpa.get(i));
            }
            else{
                System.out.print(" / " + gpa.get(i));
            }
        }
    }

    public void setData(float gpa){
        this.gpa.add(gpa);
    }

}

public class App {

    static Scanner scanf = new Scanner(System.in);
    static student newStudent;
    public static void main(String[] args) throws Exception {
        insertData();
        cls(args);

        while(true){
            menu();
            switch(op()){
                case 1:
                    cls(args);
                    viewData(0);
                    break;
                case 2:
                    cls(args);
                    updateData();
                    break;
                case 3:
                    cls(args);
                    System.exit(0);
                    break;
            }
            cls(args);
        }
    }

    public static void menu(){
        System.out.println("Wellcom " + newStudent.getName());
        System.out.println("Student Dummy Data");
        System.out.println("==================");
        System.out.println("1. View Data");
        System.out.println("2. Update Data");
        System.out.println("3. Exit");
        System.out.print(" >> ");
    }

    public static void viewData(int flag){
        System.out.println("Your name is " + newStudent.getName());
        System.out.println("Your age is " + newStudent.getAge());
        System.out.print("yout gpa is "); 
        newStudent.getGpa();
        if(flag == 0){
            System.out.println("\npress (Enter) to back to menu ..");
            scanf.nextLine();
        }
    }

    public static void updateData(){
        float gpa;
        viewData(1);
        System.out.println("\n");
        do{
            System.out.print("Input yout gpa [0.0 - 4.0 inclusive]: ");
            gpa = scanf.nextFloat();
            scanf.nextLine();
        }
        while(gpa < 0 || gpa > 4);

        newStudent.setData(gpa);
        System.out.println("Student data updated successfully");
        System.out.println("\npress (Enter) to back to menu ..");
        scanf.nextLine();
    }

    public static void insertData(){
        String name;
        int age;
        float gpa;

        System.out.println("Hello, Wellcome to Student DUmmy Data !");

        do{
            System.out.print("Input your name [3 - 15 characters] (cannot be change): ");
            name = scanf.nextLine();
        }
        while(name.length() < 3 || name.length() > 15);

        do{
            System.out.print("Input your age [min 16] (cannot be change): ");
            age = scanf.nextInt();
            scanf.nextLine();
        }
        while(age < 16);

        do{
            System.out.print("Input yout gpa [0.0 - 4.0 inclusive]: ");
            gpa = scanf.nextFloat();
            scanf.nextLine();
        }
        while(gpa < 0 || gpa > 4);

        newStudent = new student(name, age, gpa);
    }

    public static int op(){
        int op = scanf.nextInt();
        scanf.nextLine();
        return op;
    }

    public static void cls (String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
