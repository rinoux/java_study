package cc.rinoux.designpattern.proxypattern.staticproxy;

/**
 * Created by rinoux on 2017/2/14.
 */
public class CountProxy implements Count {
    CountDelegate delegate;

    public CountProxy(CountDelegate countDelegate) {
        this.delegate = countDelegate;
    }

    @Override
    public void queryCount() {
        System.out.println("查询事务处理前");
        delegate.queryCount();
        System.out.println("查询事务处理完毕");
    }

    @Override
    public void updateCount() {
        System.out.println("更新事务处理前");
        delegate.updateCount();
        System.out.println("更新事务处理完毕");
    }


    public static void main(String[] args) {
        CountDelegate delegate = new CountDelegate();//委托类
        CountProxy proxy = new CountProxy(delegate);//代理类

        proxy.queryCount();//代理执行委派任务
        proxy.updateCount();////代理执行委派任务

    }
}
