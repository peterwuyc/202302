import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw2 {

    public static void main(String[] args) {

        // Create HashMap to save data
        // Input action+ integer+name as string from keyboard

        Map<Integer, String> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String nextLine = scanner.nextLine();
            String[] arr = nextLine.split(",");

            String start = arr[0];
            String end = arr[1];

            // Example
            // Add,12,peter. // create Peter as id 12
            // Update, 12,peter1 // update Peter to Peter1
            // Get. //print map
            // Delete,12// remove Peter from map

            if (start.equalsIgnoreCase("Add")) {

                int index = Integer.parseInt(end);
                String val = arr[2];
                map.put(index, val);

            } else if (start.equalsIgnoreCase("Update")) {

                int index = Integer.parseInt(end);
                String val = arr[2];
                map.put(index, val);

            } else if (start.equalsIgnoreCase("Get")) {

                for (int index : map.keySet()) {
                    System.out.println(index + " " + map.get(index));
                }

            } else if (start.equalsIgnoreCase("Delete")) {

                int index = Integer.parseInt(end);
                map.remove(index);
            } else if (start.equalsIgnoreCase("quit")) {
                break;
            } else {
                System.out.println("wrong input, do it again");
            }
        }

    }

}
