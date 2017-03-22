package com.server.v1.model.table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wanghaoyang on 17-3-21.
 */
@Entity
@Table(name = "userinfo_changelog")
public class UserInfoChangeLog {
    @Id
    @GeneratedValue
    private int pid;
    private int userid;
    private int changetype; //0添加 1修改用户名 2修改密码 3注销
    private int changetime;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getChangetype() {
        return changetype;
    }

    public void setChangetype(int changetype) {
        this.changetype = changetype;
    }

    public int getChangetime() {
        return changetime;
    }

    public void setChangetime(int changetime) {
        this.changetime = changetime;
    }
}
