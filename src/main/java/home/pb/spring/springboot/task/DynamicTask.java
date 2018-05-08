package home.pb.spring.springboot.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@EnableScheduling
@RestController
public class DynamicTask {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    //启动定时任务
    @RequestMapping(value = "/startTask")
    public String startTask(){

        future = taskScheduler.schedule(new MyRunnable(),new CronTrigger("0/5 * * * * *"));
        System.out.println("StartTask");
        return "StartTask";
    }
    //停止定时任务
    @RequestMapping(value = "/stopTask")
    public String stopTask(){
        if(future != null){
            future.cancel(true);
        }
        System.out.println("StopTask");
        return "StopTask";
    }

    //修改定时任务
    @RequestMapping(value = "/changeCron")
    public String changeCron(){

        //先停止定时器
        stopTask();
        //再执行开始任务中的这个方法，修改定时之后的
        future = taskScheduler.schedule(new MyRunnable(),new CronTrigger("0/10 * * * * *"));
        System.out.println("changeCron");
        return "changeCron";
    }

    private class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRunnable.run" + new Date());
        }
    }
}
