package xyz.lennon.laotao_server.services;

import xyz.lennon.laotao_server.entity.User;

import java.util.List;

public interface UserService {

    boolean ismatching(String username, String password);

    boolean insert(String username, String password, String diplayName);
}
