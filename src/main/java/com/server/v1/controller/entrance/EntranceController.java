package com.server.v1.controller.entrance;

import com.server.v1.config.Route;
import com.server.v1.model.UserLoginBean;
import com.server.v1.model.table.UserInfo;
import com.server.v1.response.StateResponseData;
import com.server.v1.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghaoyang on 17-3-21.
 */

@Controller
public class EntranceController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @GetMapping(value = Route.ROUTE_LOGIN)
    public String login(Model model){
        model.addAttribute("login", new UserLoginBean());
        return "login";
    }

    @PostMapping(value = Route.ROUTE_LOGIN)
    public String loginSubmit(@ModelAttribute UserLoginBean userLoginBean, Model model){
        System.out.println(userLoginBean.getName());
        System.out.println(userLoginBean.getPassword());
        StateResponseData stateResponseData =  userInfoService.checkUserInfo(userLoginBean);
        if(stateResponseData.getState()==1){
            model.addAttribute("hello","登录成功,正在跳转...");
        }else{
            model.addAttribute("hello",String.format("登录失败,%s,正在跳转...",stateResponseData.getMsg()));
        }
        return "hello";
    }

    @RequestMapping(value = Route.ROUTE_LOGOUT, method = {RequestMethod.POST})
    public String logout(){
        return "";
    }
}
