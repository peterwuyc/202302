package homework02;

import java.util.*;

/* 
 * Requirements:
 * Create HashMap to save data
 * Input action+ integer+name as string from keyboard
 * 
 * Example
 * Add,12,peter. // create Peter as id 12
 * Update, 12,peter1 // update Peter to Peter1
 * Get. //print map
 * Delete,12// remove Peter from map
 */
public class Main {

    public static Map<Integer, Student> map = new HashMap();
    static {
        map.put(1, new Student("peter"));
        map.put(2, new Student("jack"));
        map.put(3, new Student("mike"));
    } 
    public static void main(String[] args) {
        String usage = "Usage:\n" + 
                        "<Add,id,name>: create name as id x \n" + 
                        "<Update,id,name1>: update id's name to name1\n" + 
                        "<Get>: print all map\n" + 
                        "<Delete,id>: remove id from map\n" + 
                        "<Exit>: exit the program\n" ;
        System.out.println(usage);

	    Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            String[] result = s.split(",");
            if(result[0].equalsIgnoreCase("Add")){ // create one student!!
                Integer id = Integer.parseInt(result[1]);
                if (map.containsKey(id)) {
                    System.out.println("Id already exists! Try another one.");
                    continue;
                }
                String name = result[2];
                Student student = new Student(name);
                map.put(id, student);
            }else if(result[0].equalsIgnoreCase("Get")){
                for (Map.Entry<Integer, Student> entry: map.entrySet()){
                    System.out.println("id:" + entry.getKey() + " student:" + entry.getValue());
                }
            }else if(result[0].equalsIgnoreCase("Update")){
                Integer id = Integer.parseInt(result[1]);
                if (!map.containsKey(id)) {
                    System.out.println("Id doesn't exist in the map! Try another one.");
                    continue;
                }
                String newName = result[2];
                Student student = map.get(id);
                student.name = newName;
                // map.put(id, student);

            }else if(result[0].equalsIgnoreCase("Delete")){
                Integer id = Integer.parseInt(result[1]);
                map.remove(id);                
            }else if(result[0].equalsIgnoreCase("Exit")){
                break;
            }else{
                System.out.println("Please Follow Usage");
                System.out.println(usage);
            }
        }
        scanner.close();
    }
}

