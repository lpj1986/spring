package win.elegentjs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import win.elegentjs.entity.User;
import win.elegentjs.service.UserService;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = context.getBean(UserService.class);

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch downLatch = new CountDownLatch(10);

        for (int index = 0; index < 10; index ++) {
            exe(downLatch, userService, executorService);
        }

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("插入成功， 当前记录数： " + userService.findList().size());

        executorService.shutdownNow();
    }


    private static void exe(CountDownLatch downLatch, UserService userService, ExecutorService executorService) {
        executorService.submit(() -> {
            User user = new User();
            user.setName("张三");
            user.setUsername("zhangsan3");
            user.setAge(30);
            user.setAddress("China");

            userService.save(user);

            downLatch.countDown();
        });
    }
}
