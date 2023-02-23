import java.util.*;

//1.
//Create HashMap to save data
//Input action+ integer+name as string from keyboard
//
//Example
//Add,12,peter. // create Peter as id 12
//Update, 12,peter1 // update Peter to Peter1
//Get. //print map
//Delete,12// remove Peter from map

public class Main {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
//            add, zhangsan, 10, 123@gmail.com
//            get zhangsan, return info of this student
            if(scanner.nextLine().equals("add") ){
                System.out.println("Enter the name");
                String name = scanner.nextLine();

                System.out.println("Enter the id");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the email");
                String email = scanner.nextLine();

                Student student = new Student(name,id,email);
                map.put(id,student);
                System.out.println("Student info was created successfully");
            }
            if(scanner.nextLine().equals("get")){
                System.out.println("Enter the id of the student you want to query");
                int id = scanner.nextInt();
                scanner.nextLine();
                Student stu = map.get(id);
                if(stu != null){
                    System.out.println(stu.name +","+ stu.id+","+ stu.email);
                }else{
                    System.out.println("The student info does not exist");
                }

            }

            if(("update").equals(scanner.nextLine())){
                System.out.println("Enter the id of the people you want to update");
                int id = scanner.nextInt();
                scanner.nextLine();
                Student student = map.get(id);
                System.out.println("Enter the the new name");
                String name = scanner.nextLine();
                System.out.println("Enter the the new email");
                String email = scanner.nextLine();
                student = new Student(name,id,email);
                map.put(id,student);
                System.out.println("done");
            }

            if(("delete").equals((scanner.nextLine()))){
                System.out.println("Enter the id of the people you want to delete");
                int id = scanner.nextInt();
                scanner.nextLine();
                map.remove(id);
                System.out.println("done");
            }
        }
    }
}
