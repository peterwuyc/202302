import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Student> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            if(line.equals("exit")){
                break;
            }
            processInput(line);
        }
    }

    private static void processInput(String line) {
        String[] words = line.split(",");
        String operation = words[0];
        switch (operation){
            case "Add":
                addStudent(words[1], words[2]);
                break;
            case "Update":
                updateStudent(words[1], words[2]);
                break;
            case "Get":
                getStudent();
                break;
            case "Delete":
                deleteStudent(words[1]);
                break;
            default:
                System.out.println("Your input is invalid, please check your input");

        }
    }
    private static void addStudent(String id, String name) {
        map.put(id, new Student(id, name));
    }
    private static void updateStudent(String id, String newName) {
        Student student = map.get(id);
        student.setName(newName);
        map.put(id, student); // ? needed?
    }
    private static void getStudent() {
        map.entrySet().stream().forEach(stringStudentEntry ->
                System.out.println(stringStudentEntry.getKey() + ": " + stringStudentEntry.getValue().toString()));
    }
    private static void deleteStudent(String id) {
        map.remove(id);
    }

}