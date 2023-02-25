import java.util.Scanner;
import java.util.HashMap;
public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> students = new HashMap<>();  // <id,name>
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] actions = line.trim().split(",");
            if(actions[0].equals("Add")){
                students.put(actions[1].trim(),actions[2].trim());
            }else if(actions[0].equals("Update")){
                if(!students.containsKey(actions[1].trim())){
                    System.out.println("No such Student!");
                    continue;
                }
                students.put(actions[1].trim(),actions[2].trim());
            }else if(actions[0].equals("Delete")){
                students.remove(actions[1].trim());
            }else if(actions[0].equals("Get")){
                for(String id : students.keySet()){
                    String name = students.get(id);
                    System.out.println("Student id: "+id +"  name: "+ name);
                }
            }
        }
    }
}
