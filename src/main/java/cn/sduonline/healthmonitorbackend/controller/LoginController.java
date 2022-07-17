package cn.sduonline.healthmonitorbackend.controller;

import cn.sduonline.healthmonitorbackend.domain.pojo.User;
import cn.sduonline.healthmonitorbackend.repository.UserRepository;
import cn.sduonline.healthmonitorbackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created By GuoChao on 2022/7/17 23:06
 */
@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/login", method = POST)
    @ResponseBody
    public Result<User> login(@RequestBody User user)  {
        if(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()).size()==0)
            return new Result<User>().error();
        else
            return new Result<User>().success();
    }




}

