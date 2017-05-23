package cc.rinoux.other;

/**
 * Created by rinoux on 2016/12/12.
 */
public class ClassMainRefer {
    public static void main(String[] args) {
        ParalClassMain.main(null);
        new ClassMainRefer("Tom", ParalClassMain.i).introduce();
    }

    private String name;
    private int age;

    public ClassMainRefer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("my name is " + name + ", I'm " + age + " years old");
    }
    
}

