package cc.rinoux.third.tomcat;

import com.mysql.jdbc.StringUtils;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by rinoux on 2017/5/15.
 */
public class TomcatDemo {

    public static void main(String[] args) {
        String webappDir = "/Users/rinoux/FineProjects/finereport9.0/env/WebReport";
        Tomcat tomcat  = new Tomcat();
        String webPort = System.getenv("PORT");
        if (StringUtils.isNullOrEmpty(webPort)) webPort = "8080";
        tomcat.setPort(Integer.valueOf(webPort));

        try {
            //webapp <---> standContext
            StandardContext standardContext = (StandardContext) tomcat.addWebapp("/", new File(webappDir).getAbsolutePath());
            File additionWebinfClasses = new File("/WEB-INF/classes");//备用classes路径
            WebResourceRoot resources = new StandardRoot(standardContext);
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebinfClasses.getAbsolutePath(), "/"));
            //standardContext.setResources(resources);

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException | ServletException e) {
            e.printStackTrace();
        }

    }
}
