import java.util.Scanner;

public class exercitiul5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul: ");
        int nr = scanner.nextInt();

        boolean OK = true;

        for (int i = 2; i < nr/2; i++)
            if(nr % i == 0){
                OK = false;
                break;
            }

        if (OK)
            System.out.print("Numarul este prim");
        else
            System.out.print("Numarul nu este prim");
    }
}
