package cc.rinoux.third.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * Created by rinoux on 2019-02-13.
 */
public class ByteBuddyDemo {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType= new ByteBuddy()
                .subclass(Object.class)//对象接口
                .method(ElementMatchers.named("toString"))//方法
                .intercept(FixedValue.value("Hello world"))//调用方法的拦截返回值
                .make()//创建未被加载的类
                .load(ByteBuddyDemo.class.getClassLoader())//加载生成的类
                .getLoaded();//返回加载好的类


        System.out.println(dynamicType.newInstance());
        Class<?> dtt= new ByteBuddy().subclass(TT.class).method(ElementMatchers.named("print")).intercept(new Implementation() {
            @Override
            public ByteCodeAppender appender(Target target) {
                return null;
            }

            @Override
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return null;
            }
        }).make().load(ByteBuddyDemo.class.getClassLoader()).getLoaded();
    }


    class TT {
        public String print() {
            return "xxxx";
        }
    }

}
