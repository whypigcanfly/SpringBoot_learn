package com.server.v1.controller.regist;

import com.server.v1.config.Route;
import com.server.v1.response.StateResponseData;
import com.server.v1.service.RegistUserServiceImpl;
import com.server.v1.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaoyang on 17-3-21.
 */

@RestController
public class RegistController {

    @Autowired
    private RegistUserServiceImpl registUserService;

    //获取注册页面
    @RequestMapping(value = Route.ROUTE_REGIST, method = {RequestMethod.GET})
    public String getRegistPage(){
        return "";
    }

    //上传注册信息
    @RequestMapping(value = Route.ROUTE_REGIST, method = {RequestMethod.POST})
    public StateResponseData regist(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "password") String password){
        return registUserService.registUser(name, password);
    }
}
