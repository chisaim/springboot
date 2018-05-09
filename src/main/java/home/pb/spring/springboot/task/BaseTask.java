package home.pb.spring.springboot.task;

import home.pb.spring.springboot.quartz.HelloJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


public class BaseTask implements Job{

    private String expression;

    public String getExpression() {
        return null;
    }

    @Autowired
    private Scheduler scheduler;

    @PostConstruct //等同于init-method
    public void init() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(this.getClass()).withIdentity(this.getClass().getSimpleName()+"_job",this.getClass().getSimpleName()+"group").build();

//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
//        Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("trigger1","triggergroup1").withSchedule(simpleScheduleBuilder).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(this.getClass().getSimpleName()+"trigger",this.getClass().getSimpleName()+"triggergroup").withSchedule(CronScheduleBuilder.cronSchedule(getExpression())).build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

//        scheduler.deleteJob(new JobKey("job1","group1"));

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
