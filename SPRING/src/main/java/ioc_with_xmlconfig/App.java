package ioc_with_xmlconfig;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {

        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("beanconfig.xml"));
        her h1 = (her) beanFactory1.getBean("BI");
        System.out.println(h1);

//      BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("beanconfig.xml"));
//      her h2 = beanFactory2.getBean(her.class);
//      System.out.println(h2);
//
//      her h3=(her) beanFactory2.getBean("bean_id_2");
//      System.out.println(h3);




    }
}
