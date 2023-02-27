import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // hw02
        hw02 peopleMap = new hw02();
        System.out.println("**********Welecom to the People Info Map**********");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            peopleMap.process(scanner.nextLine());
        }
    }
}