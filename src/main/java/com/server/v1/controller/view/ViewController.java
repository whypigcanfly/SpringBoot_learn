package com.server.v1.controller.view;

import com.server.v1.config.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaoyang on 17-3-21.
 */
@Controller
public class ViewController {
    @RequestMapping(value = Route.ROUTE_INDEX, method = {RequestMethod.GET})
    public String getRegistPage(ModelMap map){
        map.addAttribute("hello", "WanghaoYang");
        return "hello";
    }
}
