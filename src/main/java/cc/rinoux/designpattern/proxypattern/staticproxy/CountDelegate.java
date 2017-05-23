package cc.rinoux.designpattern.proxypattern.staticproxy;

/**
 * 账户委托类
 *
 * Created by rinoux on 2017/2/14.
 */
public class CountDelegate implements Count {
    @Override
    public void queryCount() {
        System.out.println("查询账户的方法");
    }

    @Override
    public void updateCount() {
        System.out.println("更新账户的方法");
    }
}
