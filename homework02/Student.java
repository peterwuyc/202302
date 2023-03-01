package homework02;

public class Student {
    public String name;
    public Integer age;
    public String email;

    public Student(String name){
        this.name = name;
    }
    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public Student(String name, Integer age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
