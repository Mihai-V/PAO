import java.util.Scanner;

public class exercitiul6 {
    static int fibonacci(int n){
        int a = 0;
        int b = 1;
        int c;

        if (n == 0)
            return a;

        for (int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti pozitia elementului din sir: ");
        int nr = scanner.nextInt();

        System.out.print("Elemetul de pe pozitia n din sir este: ");
        System.out.print(fibonacci(nr));
    }
}
