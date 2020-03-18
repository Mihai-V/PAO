import java.util.Scanner;

public class exercitiul1 {
    public static void main(String[] args) {
        int[] studentsGrades = new int[25];
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;

        for (; i < studentsGrades.length; i++) {
            int value = scanner.nextInt();
            if (value == -1) {
                break;
            } else {
                studentsGrades[i] = value;
                sum += value;
            }
        }
        System.out.println("The grades average is: " + sum / i);
    }
}