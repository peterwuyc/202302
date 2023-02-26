import java.util.*;

public class h2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        while (true) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(",");

            if (inputArr[0].equals("Add")) {
                int id = Integer.parseInt(inputArr[1]);
                String name = inputArr[2];
                map.put(id, name);
            } else if (inputArr[0].equals("Update")) {
                int id = Integer.parseInt(inputArr[1]);
                String name = inputArr[2];
                map.put(id, name);
            } else if (inputArr[0].equals("Delete")) {
                int id = Integer.parseInt(inputArr[1]);
                map.remove(id);
            } else if (inputArr[0].equals("Get")) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
