import java.util.Scanner;

public class exercitiul4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul: ");
        int numar = scanner.nextInt();

        int factorial = 1;

        for(int i = 2; i <=numar ; i++)
            factorial = factorial * i;

        System.out.print("Factorialul numarului este: ");
        System.out.print(factorial);
    }
}
