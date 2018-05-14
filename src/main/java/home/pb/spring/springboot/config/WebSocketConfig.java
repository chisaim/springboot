package home.pb.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    /**
     * 这个对象会自动注册，标注过@ServerEndpoint注解的websocket类
     * @return
     */
    @Bean
    public ServerEndpointExporter serverPointExporter(){
        return new ServerEndpointExporter();
    }

}
