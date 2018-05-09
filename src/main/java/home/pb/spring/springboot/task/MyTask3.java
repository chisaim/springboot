package home.pb.spring.springboot.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyTask3 extends BaseTask{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyTask3.execute() , date = " + new Date());
    }

    @Override
    public String getExpression() {
        return "0/6 * * * * ?";
    }
}
