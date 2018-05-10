package home.pb.spring.springboot.environment;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyEnvironment1 implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(environment.getProperty("JAVA_HOME"));
        System.out.println(environment.getProperty("server.port"));
    }
}
