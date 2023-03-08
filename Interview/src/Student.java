import java.util.Objects;

public class Student{//entity

    public String name;
    public Integer age;
    public String email;


    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return 1;
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
