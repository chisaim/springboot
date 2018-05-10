package home.pb.spring.springboot.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements EnvironmentAware {

    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("HelloController");
        return "hello";
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("HelloController : " + environment.getProperty("JAVA_HOME"));
        System.out.println("HelloController : " + environment.getProperty("server.port"));
    }
}
