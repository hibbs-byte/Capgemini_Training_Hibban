package dependancy_injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args)
    {
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("listdependancy.xml"));
        Library1 l1=(Library1) beanFactory1.getBean("L1");
        System.out.println(l1);

//        Book b1=(Book)beanFactory1.getBean("B1");
//        System.out.println(b1);
    }
}
