package cc.rinoux.base.classloader;

/**
 * Created by rinoux on 2017/1/4.
 */
public class NotInitialization {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("NotInitialization");
        //Thread.sleep(10000);
        /**
         * 输出：（只会初始化父类）
         * Super class inited
         * 33
         */
        //System.out.println(SubClass.value);
        /**
         * 无任何输出，不会触发SuperClass初始化，因为数组的创建是由newarray指令创建一个Object的子类cc.rinoux.classloader.SuperClass[]
         */
        //SuperClass[] superClasses = new SuperClass[10];


        /**
         * 只会输出"hello word!"，因为在编译阶段通过常量传播优化，已经将HELLO_WORLD的值储存到了NotInitialization的常量池中，
         * 因而所有NotInitialization对SuperClass.HELLO_WORLD的引用都是对自身常量池成员的引用。
         */
        System.out.println(SuperClass.HELLO_WORLD);

        Thread.sleep(1000000);

    }
}
