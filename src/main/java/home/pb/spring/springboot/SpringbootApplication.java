package home.pb.spring.springboot;

import com.github.pagehelper.PageHelper;
import home.pb.spring.springboot.quartz.HelloJob;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("home.pb.spring.springboot.mapper")
public class SpringbootApplication {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		SpringApplication.run(SpringbootApplication.class, args);

		/*
		System.out.println("scheduler.start.");
		//调度器实例,并启动调度器
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		System.out.println(scheduler.getSchedulerName());
		//创建具体任务
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
		//时间触发器，每5秒触发一次执行。
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
		//创建时间触发点
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(scheduleBuilder).build();

		//调度器开始管理时间触发点和任务
		scheduler.scheduleJob(jobDetail,trigger);
		TimeUnit.SECONDS.sleep(20);

		scheduler.shutdown();
		System.out.println("scheduler.shutdown.");
		*/
	}

	@Bean
	public PageHelper pageHelper(){
		System.out.println("MybatisConfigutarion.pageHelper()");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum","true");
		p.setProperty("rowBoundsWithCount","true");
		p.setProperty("reasonable","true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
