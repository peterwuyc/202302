
/*
        Create HashMap to save data
        Input action+ integer+name as string from keyboard

        Example
        Add,12,peter. // create Peter as id 12
        Update, 12,peter1 // update Peter to Peter1
        Get. //print map
        Delete,12// remove Peter from map
        
        
not sure about the input format
, to seperate, . as the end?
assume so and for name, only a-zA-z
*/


import java.util.HashMap;
import java.util.Map;


public class hw02 {
    HashMap<Integer, String> people;

    public hw02() {
        this.people = new HashMap<>();;
    }

    public void process(String next) {
        String[] arrOfStr = next.split(",");
        int n = arrOfStr.length;

        for (int i = 0; i < n; i++) {
            arrOfStr[i] = arrOfStr[i].replaceAll("[^a-zA-Z0-9]", "");
        }

        if (arrOfStr[0].equalsIgnoreCase("add")) {
            if (n != 3) {
                System.out.println("You should have the add input as the format `Add,ID,Name.`");
                return;
            }
            addPerson(arrOfStr);
        } else if (arrOfStr[0].equalsIgnoreCase("update")) {
            if (n != 3) {
                System.out.println("You should have the update input as the format `Update, ID,UPDATEDNAME`");
                return;
            }
            updatePersonInfo(arrOfStr);
        } else if (arrOfStr[0].equalsIgnoreCase("get")) {
            if (n != 1) {
                System.out.println("You should have the get input as the format `Get.`");
                return;
            }
            getMap();
        } else if (arrOfStr[0].equalsIgnoreCase("delete")) {
            if (n != 2) {
                System.out.println("You should have the delete input as the format `Delete, ID`.");
                return;
            }
            deletePerson(arrOfStr);
        } else {
            // todo: do I need to use try catch to give out an exception such as "input mismatch exception"?
            System.out.println("Please make sure that the available processes are Add, Update, Get and Delete");
        }
    }

    private void deletePerson(String[] arrOfStr) {
        int id = Integer.parseInt(arrOfStr[1]);
        if (this.people.containsKey(id)) {
            this.people.remove(id);
            System.out.println("Successfully removed the person!");
        } else {
            System.out.println("ERROR: the person doesn't exist!");
        }
    }

    private void getMap() {
        for (Map.Entry<Integer, String> entry : this.people.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private void updatePersonInfo(String[] arrOfStr) {
        int id = Integer.parseInt(arrOfStr[1]);
        if (this.people.containsKey(id)) {
            this.people.put(id, arrOfStr[2]);
            System.out.println("Successfully updated the person!");
        } else {
            System.out.println("ERROR: the person doesn't exist!");
        }
    }

    private void addPerson(String[] arrOfStr) {
        int id = Integer.parseInt(arrOfStr[1]);
        if (!this.people.containsKey(id)) {
            this.people.put(id, arrOfStr[2]);
            System.out.println("Successfully added the person!");
            for (Map.Entry<Integer, String> entry : this.people.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            System.out.println("ERROR: the person already existed!");
        }
    }
}
