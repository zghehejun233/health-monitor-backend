package cn.sduonline.healthmonitorbackend.controller;

import cn.sduonline.healthmonitorbackend.domain.pojo.Favorite;
import cn.sduonline.healthmonitorbackend.domain.pojo.User;
import cn.sduonline.healthmonitorbackend.repository.CookBookRepository;
import cn.sduonline.healthmonitorbackend.repository.FavoriteRepository;
import cn.sduonline.healthmonitorbackend.repository.UserRepository;
import cn.sduonline.healthmonitorbackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created By GuoChao on 2022/7/17 23:07
 */

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    CookBookRepository cookBookRepository;

    @RequestMapping(value = "/favorites", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Favorite> FavoriteGet() {
        return new Result<Favorite>().success(favoriteRepository.findAll());

    }

    @RequestMapping(value = "/user/favorites/delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Favorite> FavoriteDelete(@RequestParam Integer cid) {
        favoriteRepository.findByCid(cid);//查询获得实体对象
        favoriteRepository.delete(favoriteRepository.findByCid(cid).get(0));
        return new Result<Favorite>().success();
    }

    @RequestMapping(value = "/user/favorites/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Favorite> FavoriteAdd(@RequestParam Integer cid) {
        Favorite s = new Favorite();
        Integer id = favoriteRepository.getMaxId();  // 查询最大的id
        if (id == null)
            id = 1;
        else
            id = id + 1;
        s.setFid(id);  //设置新的id
        s.setCid(cid);
        s.setCname(cookBookRepository.findByCid(cid).get(0).getCname());
        s.setHealth_score(cookBookRepository.findByCid(cid).get(0).getHealth_store());
        favoriteRepository.save(s);
        return new Result<Favorite>().success();
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<User> InfoAdd(@RequestParam Integer uid) {

        return new Result<User>().success(userRepository.findByUid(uid).get(0));
    }

    @RequestMapping(value = "/user/name", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<User> NameUpdate(@RequestBody User user) {
        Optional<User> op = userRepository.findById(user.getUid());  //查询对应数据库中主键为id的值的实体对象
        if (op.isPresent()) {
            User s = op.get();
            s.setUsername(user.getUsername());
            userRepository.save(s);
            return new Result<User>().success();
        } else {
            return new Result<User>().error();
        }

    }

    @RequestMapping(value = "/user/avatar", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<User> AvatarUpdate(@RequestBody User user) {
        //未完成
        return new Result<User>().success();
    }
}