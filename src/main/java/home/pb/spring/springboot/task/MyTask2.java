package home.pb.spring.springboot.task;

import home.pb.spring.springboot.quartz.HelloJob;
import home.pb.spring.springboot.service.HelloService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class MyTask2 extends BaseTask{

    @Autowired
    private HelloService helloService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyTask2.execute() , date = " + new Date());
        helloService.helloService();
    }

    @Override
    public String getExpression() {
        return "0/3 * * ? * *";
    }
}
