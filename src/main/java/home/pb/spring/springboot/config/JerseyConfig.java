package home.pb.spring.springboot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(RequestContextFilter.class);
        //指定扫描的包路径
        packages("home.pb.spring.springboot.rest");
    }
}
