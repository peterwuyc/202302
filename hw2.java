
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class hw2 {

    // Create HashMap to save data
    // Input action+ integer+name as string from keyboard

    // Example
    // Add,12,peter. // create Peter as id 12
    // Update, 12,peter1 // update Peter to Peter1
    // Get. //print map
    // Delete,12// remove Peter from map

    public static void main(String[] args) {
        Map<Integer, String> student = new HashMap<>();
        // student.put("Peter", 12);
        // student.put("Joy", 2);
        // student.put("Jessie", 3);
        // student.put("Dongya", 4);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");
            String action = words[0];
            try {
                if (action.equalsIgnoreCase("Add")) {
                    String num = words[1];

                    int id = Integer.parseInt(num);
                    String name = words[2];
                    student.put(id, name);
                } else if (action.equalsIgnoreCase("update")) {
                    String num = words[1];
                    int id = Integer.parseInt(num);
                    String name = words[2];
                    if (student.containsKey(id)) {
                        student.put(id, name);
                    } else {
                        System.out.println("No record found for id:" + id);
                    }
                } else if (action.equalsIgnoreCase("Get")) {
                    for (Entry<Integer, String> entry : student.entrySet()) {
                        System.out.println("ID:" + entry.getKey() + " Name:" + entry.getValue());
                    }
                } else if (action.equalsIgnoreCase("Delete")) {
                    String num = words[1];
                    int id = Integer.parseInt(num);
                    if (student.containsKey(id)) {
                        System.out.println("Deleting ID:" + id);
                        student.remove(id);
                    }
                }else if(action.equalsIgnoreCase("exit")){
                    break;
                } else {
                    throw new Exception("Invaild action!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invailded ID!");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
        scanner.close();

    }

}