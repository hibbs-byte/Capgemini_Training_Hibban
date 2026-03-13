package annotation_config.entity;

import annotation_config.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${id}")
    private int id;
    @Value("${sname}")
    private String sname;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public static void main(String[] args)
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Student mp=applicationContext.getBean(Student.class);
        System.out.println(mp);
    }
}
