package xyz.lennon.laotao_server.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity //声明一个实体，用的是Java规范下的注解
@Table(name = "T_USER") //映射的表名称
public class User {

    @Id
    @GeneratedValue
    private Integer Id;


    @Column(length = 20)
    private String userName;

    @Column(length = 20)
    private String password;

    @Column(length = 20)
    private String displayName;

    public User(String userName, String password, String displayName) {
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }
}