package home.pb.spring.springboot;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("home.pb.spring.springboot.mapper")
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
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
