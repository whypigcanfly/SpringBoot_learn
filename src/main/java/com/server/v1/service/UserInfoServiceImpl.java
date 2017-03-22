package com.server.v1.service;

import com.server.v1.model.UserLoginBean;
import com.server.v1.model.mapper.UserInfoMapper;
import com.server.v1.model.table.UserInfo;
import com.server.v1.response.StateResponseData;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghaoyang on 17-3-21.
 */
@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public StateResponseData checkUserInfo(UserLoginBean userLoginBean){
        StateResponseData stateResponseData = new StateResponseData();
        if(userLoginBean.getPassword()==null || userLoginBean.getName()==null){
            stateResponseData.setState(0);
            stateResponseData.setMsg("请输入用户名和密码");
            return stateResponseData;
        }
        List<UserInfo> userInfos = userInfoMapper.getByName(userLoginBean.getName());
        if(userInfos.size()==0){
            stateResponseData.setState(0);
            stateResponseData.setMsg("用户不存在");
            return stateResponseData;
        }
        for(UserInfo userInfo: userInfos){
            if(userInfo.getPassword().equals(userLoginBean.getPassword())){
                stateResponseData.setState(1);
                stateResponseData.setMsg("登录成功");
                return stateResponseData;
            }
        }
        stateResponseData.setState(0);
        stateResponseData.setMsg("密码不正确");
        return stateResponseData;
    }
}
