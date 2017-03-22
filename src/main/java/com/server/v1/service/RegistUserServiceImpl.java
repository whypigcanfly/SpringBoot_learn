package com.server.v1.service;

import com.server.v1.model.mapper.UserInfoMapper;
import com.server.v1.model.table.UserInfo;
import com.server.v1.response.StateResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghaoyang on 17-3-22.
 */
@Service
public class RegistUserServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public StateResponseData registUser(String name, String password){
        List<UserInfo> users = userInfoMapper.getByName(name);
        if(users.size() != 0){
            return this.formatData(3);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setAddtime((int)(System.currentTimeMillis()/1000));
        userInfo.setPassword(password);
        userInfo.setUsername(name);
        userInfo.setStatus(1);
        int state  = userInfoMapper.save(userInfo);
        if(state==1){
            return this.formatData(1);
        }
        return this.formatData(2);
    }

    private StateResponseData formatData(int status){
        StateResponseData stateResponseData = new StateResponseData();
        switch (status){
            case 1:
                stateResponseData.setState(200);
                stateResponseData.setMsg("注册成功");
                break;
            case 2:
                stateResponseData.setState(201);
                stateResponseData.setMsg("注册失败");
                break;
            case 3:
                stateResponseData.setState(202);
                stateResponseData.setMsg("用户已存在");
                break;
            case 4:
                stateResponseData.setState(203);
                stateResponseData.setMsg("密码格式不正确");
                break;
            default:
                stateResponseData.setState(500);
                stateResponseData.setMsg("服务器错误,请联系管理员");
                break;
        }
        return stateResponseData;
    }
}
