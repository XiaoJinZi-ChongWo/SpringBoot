package com.xiaojinzi.controller;

import com.xiaojinzi.domain.Result;
import com.xiaojinzi.enums.ResultEnum;
import com.xiaojinzi.respostity.GirlRespotity;
import com.xiaojinzi.domain.Girl;
import com.xiaojinzi.properties.GirlModel;
import com.xiaojinzi.Serveries.GirlServer;
import com.xiaojinzi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JQ on 2017/9/6.
 * url接收控制层
 */

@RestController
public class GirlController {

    @Autowired
    private GirlModel girlModel;

    @Autowired
    private GirlRespotity girlRespotity;

    @Autowired
    private GirlServer girlServer;

    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String say(){
        return girlModel.getAge();
    }

    /**
     * 获取url参数
     * url：http://localhost:8080/hello/15
     * @param id
     * @return
     */
    @RequestMapping(value="/hello/{id}",method = RequestMethod.GET)
    public String value(@PathVariable("id")Integer id){
        return "id:" + id;
    }

    /**
     * 获取请求参数
     * url：http://localhost:8080/getparam?id=12
     * @param id
     * @return
     */
    @RequestMapping(value = "/getparam",method =RequestMethod.GET)
    public String value1(@RequestParam(value = "id",required = false,defaultValue = "15") Integer id){
        return  "id:" + id;
    }

    /**
     * get请求简化书写
     * @return
     */
    @GetMapping(value="/getParam/{id}")
    public String value2(@RequestParam("id") Integer id){
        return "id" + id;
    }

    /**
     * 获取表中所有数据
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRespotity.findAll();
    }

    /**
     * 添加对象
     * @param age
     * @param name
     * @return
     */
    @PostMapping(value="/girlsInsert")
    public Girl insertGirl(@RequestParam("age") Integer age,@RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);

        return girlRespotity.save(girl);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping(value="/selectGirl")
    public Girl selectGirl(@RequestParam("id") Integer id){
        return girlRespotity.findOne(id);
    }

    /**
     * 更新
     * @param id
     * @param age
     * @param name
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("age")Integer age,@RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);

        return girlRespotity.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}" )
    public void delete(@PathVariable("id") Integer id){

        girlRespotity.delete(id);
    }

    /**
     * 通过姓名查询
     * @param age
     * @return
     */
    @GetMapping(value="/girls/name/{age}")
    public List<Girl> findByName(@PathVariable("age") Integer age){
        return girlRespotity.findByAge(age);
    }

    /**
     * 插入两条数据采用事物保证一条插入失败，则另一条也插入失败
     */
    @GetMapping(value="/insertTwo")
    public void insertTwo(){
        girlServer.insertTwo();
    }

    /**
     * 通过传入对象的方式保证参数冗余
     * 同时进行表单验证
     * 并加上错误验证
     * @param girl
     * @return
     */
    @PostMapping(value = "/insertGirl")
    public Girl insertGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setAge(girl.getAge());
        girl.setName(girl.getName());
        return girlRespotity.save(girl);
    }

    /**
     * 异常抛出处理
     * 返回jason格式封装
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/insertGirle")
    public Result<Girl> insertGirlE(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.erro(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setName(girl.getName());
        girl.setAge(girl.getAge());
        return ResultUtil.success(ResultEnum.SUCCESS,girlRespotity.save(girl));
    }

    /**
     * 处理异常捕捉
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
         girlServer.checkAge(id);
    }
}
