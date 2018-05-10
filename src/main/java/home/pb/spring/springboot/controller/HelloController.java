package home.pb.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("HelloController");
        logger.info("使用logback日志进入HelloController打赢的日志");
        return "hello";
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("HelloController : " + environment.getProperty("JAVA_HOME"));
        System.out.println("HelloController : " + environment.getProperty("server.port"));
    }
}
