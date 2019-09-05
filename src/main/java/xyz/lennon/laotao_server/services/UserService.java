package xyz.lennon.laotao_server.services;

public interface UserService {

    Integer getUserId(String username);

    boolean ismatching(String email, String password);

    boolean insert(String email, String password, String diplayName);
}
