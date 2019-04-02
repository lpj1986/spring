package win.elegentjs.service;

import win.elegentjs.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findList();
}
