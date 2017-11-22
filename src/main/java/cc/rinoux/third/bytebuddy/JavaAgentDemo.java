package cc.rinoux.third.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * bytebuddy实现JavaAgent
 *
 * 1、定义premain方法
 * 2、打包成javaagent的jar，见https://blog.csdn.net/f59130/article/details/78367045
 * 3、在运行其它main函数时指定agent，-javaagent: jar文件路径[=参数]
 *
 * Created by rinoux on 2019-02-13.
 */
public class JavaAgentDemo {


    /**
     * main函数运行前调用
     *
     *     如果有另外一个premain(String args)的重载方法，
     *     premain(String args, Instrumentation instrumentation)会优先执行，
     *     而premain(String args)会被忽略
     *
     * @param args
     */
    static void premain(String args, Instrumentation instrumentation) {
        //如果类被@TestAnno注解，修改toString方法的返回值
        new AgentBuilder.Default()
                .type(ElementMatchers.isAnnotatedWith(TestAnno.class))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                        return builder.method(ElementMatchers.named("toString")).intercept(FixedValue.value("Hello world"));
                    }
                })
                .installOn(instrumentation);
    }
}
