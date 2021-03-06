package home.pb.spring.springboot;

import com.github.pagehelper.PageHelper;
import home.pb.spring.springboot.Interceptor.Myinterceptor1;
import home.pb.spring.springboot.Interceptor.Myinterceptor2;
import home.pb.spring.springboot.condition.service.CmdService;
import home.pb.spring.springboot.config.JerseyConfig;
import home.pb.spring.springboot.config.SpringBeanJobFactory;
import home.pb.spring.springboot.properties.Email2Properties;
import home.pb.spring.springboot.properties.EmailProperties;
import home.pb.spring.springboot.properties.SpringDatasource;
import home.pb.spring.springboot.quartz.HelloJob;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@MapperScan("home.pb.spring.springboot.mapper")
@EnableConfigurationProperties(value = {EmailProperties.class, SpringDatasource.class, Email2Properties.class})
//@ComponentScan(basePackages = {"home.pb.spring.springboot","home2.pb","home1.pb"})
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication//等同于上面三个注解，这个是三合一注解
public class SpringbootApplication extends WebMvcConfigurationSupport{
//public class SpringbootApplication implements WebMvcConfigurer {


	public static void main(String[] args) throws SchedulerException, InterruptedException {

//		SpringApplication.run(SpringbootApplication.class, new String[]{"SanSan","ErEr","ChiSaiM"});

		ApplicationContext ctx = SpringApplication.run(SpringbootApplication.class,args);
		CmdService cmdService = ctx.getBean(CmdService.class);
		cmdService.print();

		/*
		ApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, new String[]{"SanSan","ErEr","ChiSaiM"});
//		String[] beans = ctx.getBeanDefinitionNames();//获取容器所有的加载对象
//			@Service
//			@Controller
//			@Repository
//			@Component
//			@Configuration
//			@RestController
		String[] beans = ctx.getBeanNamesForAnnotation(RestController.class);//获取容器中添加这此注解的所有对象
		int i = 0;
		for(String bean : beans){
			System.out.println(i++ + " : " + bean);
		}
		*/

		/*
		//自动任务其中一中实现方式
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

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Myinterceptor1());
		registry.addInterceptor(new Myinterceptor2());
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//是否设置后缀匹配模式，如开启true，那么/user.html、/user.aa、/user.*都是可以访问的
		//如关闭false，就只能访问/user或/user/（前提是setUseTrailingSlashMatch这个是开启的）
		configurer.setUseSuffixPatternMatch(false);
		//是否设置路径后缀自动匹配模式，如开启，那么/user就会匹配/user/
		//如关闭，那就只会匹配/user
		configurer.setUseTrailingSlashMatch(true);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		//拦截请求/rest/*
		ServletRegistrationBean bean = new ServletRegistrationBean(new ServletContainer(),"/rest/*");
		//配置JerseyConfig  :  javax.ws.rs.Application
		bean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return bean;
	}
}
