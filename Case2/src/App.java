import java.util.Scanner;

class student{
    final String name;
    final int age;
    protected float gpa;

    student(String name, int age, Float gpa){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public float getGpa(){
        return this.gpa;
    }

    public void setData(String name, float gpa){
        this.gpa = gpa;
    }

}

public class App {

    static Scanner scanf = new Scanner(System.in);
    static student newStudent;
    public static void main(String[] args) throws Exception {
        while(true){
            insertData();
            switch(op()){
                case 1:
                    viewData();
                    break;
                case 2:
                    break;
                case 3:
                System.exit(0);
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Wellcom ");
        System.out.println("Student Dummy Data");
        System.out.println("==================");
        System.out.println("1. View Data");
        System.out.println("2. Update Data");
        System.out.println("3. Exit");
        System.out.println(" >> ");
    }

    public static void viewData(){
        System.out.println("Your name is " + newStudent.getName());
        System.out.println("Your age is " + newStudent.getAge());
        System.out.println("yout gpa is " + newStudent.getGpa());
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
            System.out.print("Input yout gpa [0.0 - 4.0 inclusive]: -1");
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


}
