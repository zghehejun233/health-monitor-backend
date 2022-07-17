package cn.sduonline.healthmonitorbackend.controller;

import cn.sduonline.healthmonitorbackend.domain.pojo.Ingredient;
import cn.sduonline.healthmonitorbackend.repository.IngredientRepository;
import cn.sduonline.healthmonitorbackend.util.OkhttpUtil;
import cn.sduonline.healthmonitorbackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By GuoChao on 2022/7/17 23:04
 */

@Controller
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping(value = "/Ingredient/Delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Ingredient> IngredientDelete(@RequestParam Integer iid) {
        Ingredient s = null;
        Optional<Ingredient> op;
        if (iid != null) {
            op = ingredientRepository.findById(iid);   //查询获得实体对象
            if (op.isPresent()) {
                s = op.get();
            }
        }
        if (s != null) {
            ingredientRepository.delete(s);    //数据库永久删除
        }
        return new Result<Ingredient>().success();

    }

    @RequestMapping(value = "/Ingredient/Get", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Ingredient> IngredientQuery(@RequestParam Integer iid) {
        return new Result<Ingredient>().success(ingredientRepository.findByIid(iid).get(0));
    }

    @RequestMapping(value = "/Ingredient/Add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Ingredient> IngredientAdd(@RequestParam String code) throws IOException {
        String html;
        String url = "https://www.meishichina.com/YuanLiao/" + code + "/useful/";
        html = OkhttpUtil.doGet(url);
        Pattern foodpattern = Pattern.compile("<p><strong>食材简介</strong></p>\n" +
                "<p>(.*?)</p>\n" +
                "<p><strong>营养价值</strong></p>\n" +
                "<p>(.*?)</p>\n" +
                "<p><strong>食用功效</strong></p>\n" +
                "<p>(.*?)</p>\n" +
                "<p><strong>适用人群</strong></p>\n" +
                "<p>(.*?)</p>\n" +
                "<p><strong>禁忌人群</strong></p>\n" +
                "<p>(.*?)</p>\n" +
                "<p><strong>选购技巧</strong></p>\n" +
                "<p>(.*?)</p>", Pattern.DOTALL | Pattern.MULTILINE);

        Matcher food = foodpattern.matcher(html);
        while (food.find()) {

            Ingredient s = new Ingredient();


            Integer id = ingredientRepository.getMaxId();  // 查询最大的id
            if (id == null)
                id = 1;
            else
                id = id + 1;
            s.setIid(id);  //设置新的id
            s.setValue(food.group(2).replaceAll("<br />", ""));
            s.setEffect(food.group(3).replaceAll("<br />", ""));
            s.setIname("");//设置属性
            s.setSkill(food.group(6).replaceAll("<br />", ""));
            s.setIntroduction(food.group(1).replaceAll("<br />", ""));
            s.setApplicablePeople(food.group(4).replaceAll("<br />", ""));
            s.setTabooPeople(food.group(5).replaceAll("<br />", ""));
            foodpattern = Pattern.compile("<h1><a title=\"(.*?)\" href=\"https://www.meishichina.com/YuanLiao/(.*?)/\" id=\"category_title\">(.*?)</a></h1>", Pattern.DOTALL | Pattern.MULTILINE);

            food = foodpattern.matcher(html);
            while (food.find()) {
                s.setIname(food.group(3));
            }

            ingredientRepository.save(s);

        }
        return new Result<Ingredient>().success();
    }

    @RequestMapping(value = "/Ingredient/GetList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Ingredient> IngredientListGet(@RequestParam Integer page_size, @RequestParam Integer page, @RequestParam(defaultValue = "", required = false) String query) {
        PageRequest pageRequest = PageRequest.of(page, page_size);
        Page<Ingredient> markerPage = ingredientRepository.findAll(pageRequest);
          /*  for (int i = 0; i < markerPage.getContent().size(); i++) {
                System.out.println(markerPage.getContent().get(i));
                System.out.println(markerPage.getTotalElements());
            }*/
        markerPage.getContent();
        return new Result<Ingredient>().success(markerPage.getContent());
    }
}


