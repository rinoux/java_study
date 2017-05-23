package cc.rinoux.designpattern.proxypattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by rinoux on 2017/2/16.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;//委托类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 所代理的真实对象（委托对象）
     * @param method 所要调用的真实对象方法的Method对象
     * @param args 调用真实对象时传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("委托类的getName方法将被代理执行");
            //Object result = method.invoke(target, args);
            Object result = "小明";
            System.out.println("委托类的getName方法被代理执行完毕");
            return result;
        } else {
            Object result = method.invoke(target, args);
            return result;
        }
    }


    public static void main(String[] args) {
        //委托类
        UserService delegate = new UserServiceDelegate();
        //代理类处理的逻辑
        InvocationHandler invocationHandler = new MyInvocationHandler(delegate);

        /**
         * Proxy.newProxyInstance的三个参数作用分别是：
         * classloader：确定代理类的class loader
         * interface 代理类需要实现的接口列表
         * invocationHandler 确定代理者的处理逻辑
         */
        //代理类
        UserService proxy = (UserService) Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), invocationHandler);

        System.out.println("代理执行结果:" + proxy.getName(1));
    }
}
