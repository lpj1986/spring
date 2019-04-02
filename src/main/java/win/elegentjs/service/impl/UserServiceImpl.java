package win.elegentjs.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


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
}
