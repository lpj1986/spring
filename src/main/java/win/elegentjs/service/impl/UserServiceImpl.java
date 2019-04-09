package win.elegentjs.service.impl;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import win.elegentjs.entity.User;
import win.elegentjs.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, ApplicationContextAware {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ApplicationContext applicationContext;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Transactional
    @Override
    public void save(User user) {
        jdbcTemplate.update("insert INTO T_USER (name, user_name, age, address) values (?, ?, ?, ?)",
                user.getName(), user.getUsername(), user.getAge(), user.getAddress());

        executorService.submit(() -> {
            throw new IllegalStateException("出错了");
        });

    }

    @Transactional
    @Override
    public List<User> findList() {
       return jdbcTemplate.query("select * from T_USER", (rs, rowNum) -> {
            User user = new User();
            user.setUsername(rs.getString("user_name"));
            user.setName(rs.getString("name"));
            user.setAddress(rs.getString("address"));
            user.setAge(rs.getInt("age"));

            return user;
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
