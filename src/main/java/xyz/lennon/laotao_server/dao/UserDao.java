package xyz.lennon.laotao_server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lennon.laotao_server.entity.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    //    User getOne(String name);
    List<User> findAllByUserName(String username);
}