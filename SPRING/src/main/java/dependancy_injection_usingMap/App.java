package dependancy_injection_usingMap;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args)
    {
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("map_kit.xml"));
        Kit k1=(Kit) beanFactory1.getBean("kit_id");
        System.out.println(k1);
    }
}
