package home.pb.spring.springboot.condition.config;

import home.pb.spring.springboot.condition.LinuxCondition;
import home.pb.spring.springboot.condition.WindowCondition;
import home.pb.spring.springboot.condition.service.CmdService;
import home.pb.spring.springboot.condition.service.LinuxCmdService;
import home.pb.spring.springboot.condition.service.WindowsCmdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CmdServiceConitionConfig {

    @Bean("cmdService")
    @Conditional(WindowCondition.class)
    public CmdService windowsCmdService(){
        return new WindowsCmdService();
    }

    @Bean("cmdService")
    @Conditional(LinuxCondition.class)
    public CmdService linuxCmdService(){
        return new LinuxCmdService();
    }

}
