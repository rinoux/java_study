package cc.rinoux.jmx;

/**
 * Created by rinoux on 2017/11/29.
 */
public interface HelloMBean {
    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);

    void helloWorld();

    void helloWorld(String msg);

    long getTelephone();
}
