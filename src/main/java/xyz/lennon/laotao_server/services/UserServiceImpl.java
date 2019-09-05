package xyz.lennon.laotao_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lennon.laotao_server.dao.UserDao;
import xyz.lennon.laotao_server.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    public List<User> findAllUser(String email) {
        return userDao.findAllByEmail(email);
    }

    @Override
    public Integer getUserId(String username) {
        return userDao.findAllByEmail(username).get(0).getId();
    }

    @Override
    public boolean ismatching(String email, String password) {
        try {
            return findAllUser(email).get(0).getPassword().equals(password);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean insert(String email, String password, String displayName) {
        try {
            userDao.saveAndFlush(new User(email, password, displayName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
