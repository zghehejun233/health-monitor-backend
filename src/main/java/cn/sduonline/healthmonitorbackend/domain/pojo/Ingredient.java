package cn.sduonline.healthmonitorbackend.domain.pojo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 * Created By GuoChao on 2022/7/17 22:55
 */

@Entity
@Table(name = "ingredient",
        uniqueConstraints = {
        })
@Getter
@Setter
public class Ingredient {
    @Id
    private Integer iid;//id
    @NotNull
    private String iname;//名称
    @Column(length = 1000)
    private String value;//营养价值

    private String applicablePeople;//适用人群
    @Column(length = 1000)
    private String effect;//食用功效
    @NotNull
    private String introduction;//简介
    @Column(length = 1000)
    private String skill;//选购技巧
    private String tabooPeople;//禁忌人群

    private Integer getIid() {
        return iid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ingredient")
    private List<Dishes> dishes;

    public void setIid(Integer value) {
        this.iid = value;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String value) {
        this.iname = value;
    }

    public String getApplicablePeople() {
        return applicablePeople;
    }

    public void setApplicablePeople(String value) {
        this.applicablePeople = value;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String value) {
        this.effect = value;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String value) {
        this.introduction = value;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String value) {
        this.skill = value;
    }

    public String getTabooPeople() {
        return tabooPeople;
    }

    public void setTabooPeople(String value) {
        this.tabooPeople = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[id=" + iid + ", iname=" + iname + "]";
    }

}
