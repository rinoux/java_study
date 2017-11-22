package cc.rinoux.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by rinoux on 2017/11/29.
 */
public class HelloAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("jmxBean:name=hello");

        mbs.registerMBean(new Hello("ted", 23, 1000000), name);

        Thread.sleep(1000*60);

    }
}
