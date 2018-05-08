package home.pb.spring.springboot.task;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerTasks {

    public void execute(){
        System.out.println("execute,date=" + new Date());
    }
}
