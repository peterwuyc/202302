import java.util.List;

public interface StudentService {

    Student getById(String input);
    void createStudent(String input);
    List<Student> getAll();
    List<Student> getAllSorted();
}
