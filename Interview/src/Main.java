import java.util.*;

public class Main {


    public static void main(String args[]){
        // MVC ->  decouple
        // Model view controller
        // View -> UI
        // Model ->entity
        // Controller->
//        StudentService studentService=new StudentServiceImplement();
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNext()){
//            String input=scanner.next();
//            if (input.contains("add")){  //Control
//                studentService.createStudent(input);
//            }else if(input.contains("get")){
//                Student student=studentService.getById(input);
//                System.out.println(student);
//            }else if(input.contains("list")){
//                List<Student> students=studentService.getAll();
//                System.out.println(students);
//            }else if(input.contains("sort")){
//                List<Student> students=studentService.getAllSorted();
//                System.out.println(students);
//            }
//        }

        // thread !!!
        // create thread
        //1. extend thread class
        //2. implements runnable interface
        //FunctionalInterface -> only have one abstract method

        // 1 deadlock 2.livelock 3 starvation
        System.out.println(Thread.currentThread().getName());
//        MyThread myThread=new MyThread();
//        Thread t1=new Thread(myThread);
//        t1.start();

        Thread t2=new Thread(()->{
            Thread.currentThread().setName("my thread 2");
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        });
        t2.start();

    }


}