package win.elegentjs.myspring;

import win.elegentjs.myspring.factory.XmlBeanFactory;
import win.elegentjs.myspring.sample.OrgService;

public class Main {

    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory("spring");
        OrgService orgService = beanFactory.getBean("orgServiceImpl", OrgService.class);
        OrgService orgService2 = beanFactory.getBean("orgServiceImpl", OrgService.class);

        System.out.println(orgService);
        System.out.println(orgService2);
    }
}
