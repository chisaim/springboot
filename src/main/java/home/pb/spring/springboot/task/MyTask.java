package home.pb.spring.springboot.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class MyTask {

    /**
     * 10s 秒 分钟 小时 日期 月 星期 年（可选）
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void test1(){
//        System.out.println("MyTask.test1()" + new Date());
    }


    /**
     * 60s
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void test2(){
//        System.out.println("MyTask.test2()" + new Date());
    }

}
