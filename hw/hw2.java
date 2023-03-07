
/*
1.
Create HashMap to save data
Input action+ integer+name as string from keyboard

Example
Add,12,peter. // create Peter as id 12
Update, 12,peter1 // update Peter to Peter1
Get. //print map
Delete,12// remove Peter from map
*/
import java.util.HashMap;
import java.util.Scanner; //import Scanner
public class hw2 {
    HashMap map = new HashMap();
    public void run(){
        Scanner keyboard = new Scanner(System.in); //Scanner
        String input;
        int id;
        String name;
        while(true){
            System.out.println("Enter action:add/update/delete/get:");
            input = keyboard.next();
            if(input.equals("add")) {
                System.out.println("Enter id:");
                id = keyboard.nextInt();
                System.out.println("Enter name:");
                name = keyboard.next();
                map.put(id, name);
                System.out.println("you have successfully added");
            } else if (input.equals("update")) {
                System.out.println("Enter id:");
                id = keyboard.nextInt();
                if (map.containsKey(id)) {
                    System.out.println("Enter name:");
                    name = keyboard.next();
                    map.put(id, name);
                    System.out.println("you have successfully updated");
                } else {
                    System.out.println("Id not found.");
                }

            } else if (input.equals("get")) {
                System.out.println("Enter id:");
                id = keyboard.nextInt();
                if (map.containsKey(id)) {
                    map.get(id);
                    System.out.println(id + ":"+map.get(id));
                } else {
                    System.out.println("Id not found.");
                }
            }else if (input.equals("delete")) {
                System.out.println("Enter id:");
                id = keyboard.nextInt();
                if (map.containsKey(id)) {
                    map.remove(id);
                    System.out.println("Record removed successfully.");
                } else {
                    System.out.println("Id not found.");
                }
            } else {
                System.out.println("you have entered the wrong action, pls try again: add/update/get/delete");
            }
        }
    }
}