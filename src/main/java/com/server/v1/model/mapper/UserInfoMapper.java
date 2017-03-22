package com.server.v1.model.mapper;

import com.server.v1.model.mapper.dao.UserInfoDao;
import com.server.v1.model.table.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wanghaoyang on 17-3-21.
 */
@Service
public class UserInfoMapper {

    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional
    public int save(UserInfo userInfo){
        userInfo =  userInfoDao.save(userInfo);
        if(userInfo==null){
            return 0;
        }
        return 1;
    }

    @Transactional
    public List<UserInfo> getByName(String name){
        List<UserInfo> userInfos = userInfoDao.findByUsername(name);
        return userInfos;
    }

    @Transactional
    public UserInfo getByUserId(int id){
        UserInfo userInfo = new UserInfo();
//        userInfo = userInfoDao.findOne((long)id);
        return userInfo;
    }
}
