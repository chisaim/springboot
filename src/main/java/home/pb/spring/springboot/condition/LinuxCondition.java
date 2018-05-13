package home.pb.spring.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    //返回true，才会执行
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //操作系统是window的
        return conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
