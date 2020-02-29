import java.util.Scanner;

public class exercitiul7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul: ");
        int nr = scanner.nextInt();

        int max_factor = -1;
        int div = 2;

        while (nr > 1){
            while (nr % div == 0)
                nr = nr / div;
            max_factor = div;
            div++;
        }

        System.out.print("Cel mai mare factor prim este: ");
        System.out.print(max_factor);
    }
}
