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


    public List<User> findAllUser(String username) {
        return userDao.findAllByUserName(username);
    }

    @Override
    public boolean ismatching(String username, String password) {
        try {
            return findAllUser(username).get(0).getPassword().equals(password);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean insert(String username, String password, String displayName) {
        try {
            userDao.saveAndFlush(new User(username, password, displayName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
