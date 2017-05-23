package cc.rinoux.base;

/**
 * Created by rinoux on 2016/12/20.
 */
public class TryCatchReturn {

    public static void main(String[] args) {

        System.out.println(test());
    }

    static Object test() {
        try {
            System.out.println("try.........");
            return "return";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //System.out.println("finally.....");
            return "finally...return....";
        }

    }
}
