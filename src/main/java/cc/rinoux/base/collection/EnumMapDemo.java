package cc.rinoux.base.collection;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by rinoux on 2017/4/7.
 */
public class EnumMapDemo {

    /**
     * EnumMap用数组保存数据，因此效率极高，EnumMap的作用是以Enum枚举元素为键值的Map，本质上只保存枚举元素ordinal值为下标的数组元素，put和get都是先计算ordinal值，再将value放入vals数组下标为ordinal的位置。
     */

    private enum TopGrades {
        MATH("张三", 98), CHINESE("李四", 95), MUSIC("王五", 89);

        private String student;
        private int grade;

        TopGrades(String student, int grade) {
            this.student = student;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        EnumMap<TopGrades, String> enumMap = new EnumMap<TopGrades, String>(TopGrades.class);

        enumMap.put(TopGrades.CHINESE, "李四同学的介绍");
        enumMap.put(TopGrades.MATH, "张三同学的介绍");
        enumMap.put(TopGrades.MUSIC, "王五同学的介绍");

        for (Map.Entry<TopGrades, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey().student + ":" + entry.getKey().grade + ", 以下是" + entry.getValue());
        }
    }
}
