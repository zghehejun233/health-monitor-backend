package cn.sduonline.healthmonitorbackend.domain.pojo;

import javax.persistence.*;

/**
 * Created By GuoChao on 2022/7/17 23:02
 */
@Entity
@Table(name = "user",
        uniqueConstraints = {
        })
public class User {
    @Id
    private Integer uid;
    private String username;
    private String password;


    public int getUid() {
        return uid;
    }

    public void setUid(int id) {
        this.uid = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

