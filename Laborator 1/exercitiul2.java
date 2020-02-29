import java.util.Scanner;

public class exercitiul2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Integer:");
        int x = scanner.nextInt();

        System.out.println("Enter second Integer:");
        int y = scanner.nextInt();

        if(x == y){
            System.out.print(x);
            System.out.print(" = ");
            System.out.println(y);
        }
        else {
            System.out.print(x);
            System.out.print(" != ");
            System.out.println(y);
        }

        if(x < y){
            System.out.print(x);
            System.out.print(" < ");
            System.out.println(y);
        }
        else {
            System.out.print(x);
            System.out.print(" > ");
            System.out.println(y);
        }

        if(x <= y){
            System.out.print(x);
            System.out.print(" <= ");
            System.out.println(y);
        }
        else {
            System.out.print(x);
            System.out.print(" >= ");
            System.out.println(y);
        }
    }
}
