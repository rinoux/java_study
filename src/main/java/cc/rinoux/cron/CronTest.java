/*
package cc.rinoux.cron;

import com.fr.third.org.quartz.CronExpression;
import com.fr.third.org.quartz.CronTrigger;
import com.fr.third.org.quartz.JobDetail;
import com.fr.third.org.quartz.Scheduler;
import com.fr.third.org.quartz.SchedulerFactory;
import com.fr.third.org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

*/
/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2020/8/20
 *//*

public class CronTest {


    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //Create JobDetail object specifying which Job you want to execute
        JobDetail jobDetail = new JobDetail("myJobClass", "myJob1", CronTest.class);

        //Associate Trigger to the Job
        CronTrigger trigger = new CronTrigger("cronTrigger", "myJob1", "0 0/1 * * * ?");

        //Pass JobDetail and trigger dependencies to schedular
        scheduler.scheduleJob(jobDetail, trigger);

        //Start schedular
        scheduler.start();


        CronExpression expression = new CronExpression("0 0/30");
        expression.getNextValidTimeAfter(new Date());
    }
}
*/
