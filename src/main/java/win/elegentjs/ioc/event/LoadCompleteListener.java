package win.elegentjs.ioc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class LoadCompleteListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("============= applicationContext container load completed. ");
    }
}
