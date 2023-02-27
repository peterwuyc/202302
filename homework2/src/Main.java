import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Name> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

            if(scanner.nextLine().equals("add") ){
                System.out.println("Enter Name");
                String name = scanner.nextLine();

                System.out.println("Enter id");
                int id = scanner.nextInt();
                scanner.nextLine();
                Name student = new Name(name,id);
                map.put(id,student);
                System.out.println("Information was stored");
            }
            if(scanner.nextLine().equals("get")){
                System.out.println("Enter Id");
                int id = scanner.nextInt();
                scanner.nextLine();
                Name stu = map.get(id);
                if(stu != null){
                    System.out.println(stu.name +","+ stu.id);
                }else{
                    System.out.println("None exist");
                }

            }

            if(("update").equals(scanner.nextLine())){
                System.out.println("Enter ID of the name you want print");
                int id = scanner.nextInt();
                scanner.nextLine();
                Name student = map.get(id);
                System.out.println("Enter a new name");
                String name = scanner.nextLine();

                map.put(id,student);
                System.out.println("done");
            }

            if(("delete").equals((scanner.nextLine()))){
                System.out.println("Enter ID of the name you want delete");
                int id = scanner.nextInt();
                scanner.nextLine();
                map.remove(id);
                System.out.println("done");
            }
        }
    }
}