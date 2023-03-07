import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentServiceImplement implements StudentService{

    Repository repository=new RepositoryImplement();
    @Override
    public Student getById(String input) {
        String[] strings=input.split(",");
        Integer id=Integer.parseInt(strings[1]);
        return repository.getByKey(id);
    }

    @Override
    public void createStudent(String input) {
        String[] strings=input.split(",");
        Integer id=Integer.parseInt(strings[1]);
        String name=strings[2];
        Student student=new Student();
        student.name=name;
        repository.create(id,student);
    }

    @Override
    public List<Student> getAll() {
        Map<Integer,Student> map=repository.getAll();
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllSorted() {
        Map<Integer,Student> map= repository.getAll(); //reuse
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted((s1,s2)->s1.age-s2.age)
                .collect(Collectors.toList());
    }
}
