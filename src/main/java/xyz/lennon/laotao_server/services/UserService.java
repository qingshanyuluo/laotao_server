package xyz.lennon.laotao_server.services;

import xyz.lennon.laotao_server.entity.User;

import java.util.List;

public interface UserService {

    boolean ismatching(String email, String password);

    boolean insert(String email, String password, String diplayName);
}
