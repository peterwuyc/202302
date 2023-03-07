import java.util.Map;

public interface Repository {

    Student getByKey(Integer key);
    void create(Integer key,Student student);
    Map<Integer,Student> getAll();
}
