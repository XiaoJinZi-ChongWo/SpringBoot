package com.xiaojinzi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 数据库girl实体类
 * Created by JQ on 2017/9/6.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @NotNull(message = "金额必传")
    private Double money;


    //通过min注解的方式过滤
    @Min(value = 18,message = "未满18静止入内")
    private Integer age;



    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {

        return money;

    }

    public void setMoney(Double money) {

        this.money = money;

    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
