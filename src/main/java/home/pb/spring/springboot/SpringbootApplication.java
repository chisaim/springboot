package home.pb.spring.springboot;

import com.github.pagehelper.PageHelper;
import home.pb.spring.springboot.Interceptor.Myinterceptor1;
import home.pb.spring.springboot.Interceptor.Myinterceptor2;
import home.pb.spring.springboot.quartz.HelloJob;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("home.pb.spring.springboot.mapper")
public class SpringbootApplication extends WebMvcConfigurationSupport{


	public static void main(String[] args) throws SchedulerException, InterruptedException {
		SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("scheduler.start.");
		//调度器实例,并启动调度器
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		System.out.println(scheduler.getSchedulerName());
		//创建具体任务
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob","job_group1").build();
		//时间触发器，每5秒触发一次执行。
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
		//创建时间触发点
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger1","trigger_group1").startNow().withSchedule(scheduleBuilder).build();
		//调度器开始管理时间触发点和任务
		scheduler.scheduleJob(jobDetail,trigger);
		TimeUnit.SECONDS.sleep(20);
		scheduler.shutdown();
		System.out.println("scheduler.shutdown.");
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

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new Myinterceptor1());
		registry.addInterceptor(new Myinterceptor2());
		super.addInterceptors(registry);
	}
}
