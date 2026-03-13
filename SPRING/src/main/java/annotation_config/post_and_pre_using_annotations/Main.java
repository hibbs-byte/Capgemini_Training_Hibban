package annotation_config.post_and_pre_using_annotations;

import annotation_config.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle v=applicationContext.getBean(Vehicle.class);
      //  System.out.println(v);
        ((AbstractApplicationContext) applicationContext).close();
    }
}
