package cc.rinoux.base.hashcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by rinoux on 2017/2/8.
 */
public class MyObject {

    private String field1;
    private Map<String, Object> field2;

    public MyObject(String field1, Map<String, Object> field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
        //return 7* field1.hashCode() + 34 *field2.hashCode();
    }

    public static void main(String[] args) {
        String f1 = "hello";
        Map<String, Object> f2 = new HashMap<>();

        f2.put("para1", "value1");

        MyObject object1 = new MyObject(f1, f2);
        MyObject object2 = new MyObject(f1, f2);

        System.out.println(object1.hashCode() + "| " + object2.hashCode());
    }
}
