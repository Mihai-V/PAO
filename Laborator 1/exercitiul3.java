import java.util.Scanner;

public class exercitiul3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti valoarea lui n:");
        int n = scanner.nextInt();

        int suma = 0;

        for (int i = 3; i <= n; i++)
            if(i % 3 == 0 || i %5 == 0)
                suma = suma + i;

        System.out.print("Suma este: ");
        System.out.print(suma);
    }
}
