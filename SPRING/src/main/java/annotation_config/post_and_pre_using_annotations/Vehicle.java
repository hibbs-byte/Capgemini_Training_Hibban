package annotation_config.post_and_pre_using_annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Vehicle {
    public Vehicle() {
        System.out.println("Vehicle()");
    }

    @PostConstruct
    public void moving()
    {
        System.out.println("vehicle is moving");
    }
    @PreDestroy
    public void accident()
        {
            System.out.println("Thank god");
            }
}



