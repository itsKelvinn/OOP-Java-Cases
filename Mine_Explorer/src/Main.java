import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class player{
    protected int x;
    protected int y;
    
    player(){
        this.x = 1;
        this.y = 1;
    }
}
class gold{
    protected int x;
    protected int y;

    gold(int x , int y){
        this.x = x;
        this.y = y;
        checkPos(x,y);
    }

    void checkPos(int x,int y){
        if(x == 1 && y == 1){
            this.x = this.x + 1;
            this.y = this.y + 1;
        }
        else if(x == 0){
            this.x = this.x + 1;
        }
        else if(y == 0){
            this.y = this.y + 1;
        }
    }

}


public class Main {

    static Scanner scanf = new Scanner(System.in); 
    static Random random = new Random();
    static ArrayList<gold> golds = new ArrayList<>();

    static player p = new player();

    public static void goldSpawns(){
        for(int i = 0; i < 5; i++){
            gold g = new gold(random.nextInt(9),random.nextInt(9));
            golds.add(g);
        }
    }

    
    public static void main(String[] args) throws Exception {
        goldSpawns();
        while(true){
            cls(args);
            display();
            kontol();
        }
    }


    public static void display(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                int flag = 0;
                if(i == 0 || i == 9 || j == 0 || j == 9){
                    System.out.print("=");
                    flag = 1;
                }
                else if(p.x == j && p.y == i){
                    System.out.print("P");
                    flag = 1;
                }
                else{
                    for(int k = 0; k < golds.size(); k++){
                        if(golds.get(k).y == i && golds.get(k).x == j){
                            System.out.print("G");
                            flag = 1;
                        }
                    }
                }

                if(flag == 0){
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
        }

        for(int k = 0; k < golds.size(); k++){
            if(golds.get(k).x == p.x && golds.get(k).y == p.y){
                golds.remove(k);
            }
        }
    }

    public static void kontol(){
        char input = scanf.next().charAt(0);
        scanf.nextLine();

        if(input == 'a'){
            p.x = p.x - 1;
        }
        else if(input == 's'){
            p.y = p.y + 1;
        }
        else if(input == 'w'){
            p.y = p.y - 1;
        }
        else if(input == 'd'){
            p.x = p.x + 1;
        }
        else if(input == 'x'){
            showGoldCoor();
            scanf.nextLine();
        }
        else if(input == 'p'){
            playerCoor();
            scanf.nextLine();
        }
    }

    public static void showGoldCoor(){
        for(int i = 0; i < golds.size(); i++){
            System.out.printf("Golds[%d] (%d,%d)\n",i,golds.get(i).x,golds.get(i).y);
        }
    }

    public static void playerCoor(){
        System.out.printf("p (%d,%d)",p.x,p.y);
    }

    public static void cls (String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}