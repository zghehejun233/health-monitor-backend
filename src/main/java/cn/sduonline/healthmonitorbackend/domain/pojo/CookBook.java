package cn.sduonline.healthmonitorbackend.domain.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created By Tian Shucheng on 2022/7/17 18:34
 */
@Entity
@Table(name = "cookbook",
        uniqueConstraints = {
        })
@Getter
@Setter
public class CookBook {
    @Id
    public Long cid;//id

    public String cname;//菜谱名称
    public String introduction;//菜谱简介

    public double health_store;//健康指数

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cookbook")
    private List<Dishes> dishes;
}
