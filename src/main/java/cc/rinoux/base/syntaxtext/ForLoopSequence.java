package cc.rinoux.base.syntaxtext;

/**
 * Created by rinoux on 2016/12/19.
 */
public class ForLoopSequence {

    public static void main(String[] args) throws InterruptedException {
        /**
         * for语句的格式：
         for(<初始化(可以为空)>; <条件表达式(必须存在)>; <增量(可以为空)>) {
             <循环语句>
         }
         执行顺序如下：
         初始化->条件表达式->循环语句->增量->条件表示式->循环语句-增量->...->条件表达式。
         在执行的时候，初始化语句只执行一次，后续按照条件表达式进行判断，如果符合条件，则执行[语句]，然后执行增量。再根据条件表示式进行判断，重复上面过程。
         for语句相当于在while语句的基础上增加了循环初始条件和增量变化， 除去这两点（不写，如下），就和while语句一个效果。
         */


        for (; true; ) {
            System.out.println("执行");
            Thread.sleep(1000);
        }
    }
}
