import java.util.HashMap;
import java.util.Map;

public class RepositoryImplement implements Repository{


    public static Map<Integer,Student> map=new HashMap<>();

    static {
        map.put(1,new Student("peter",20));
        map.put(2,new Student("jack",24));
        map.put(3,new Student("mike",18));
    }

    public Student getByKey(Integer key){
        return map.get(key);// query select * from student g
    }

    public void create(Integer key,Student student){
        map.put(key,student);
    }

    @Override
    public Map<Integer, Student> getAll() {
        return map;
    }


}
