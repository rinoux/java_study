package cc.rinoux.jmx;

/**
 * Created by rinoux on 2017/11/29.
 */
public class Hello implements HelloMBean {
    private String name;
    private int age;
    private long telephone;


    public Hello(String name, int age, long telephone) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public void helloWorld() {

        System.out.println("hello world");
    }

    @Override
    public void helloWorld(String msg) {
        System.out.println("hello world : " + msg);

    }

    @Override
    public long getTelephone() {
        return telephone;
    }
}
