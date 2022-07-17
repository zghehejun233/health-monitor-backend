package cn.sduonline.healthmonitorbackend.domain.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created By Tian Shucheng on 2022/7/17 18:34
 */

@Entity
@Table(name = "dishes",
        uniqueConstraints = {
        })
@Getter
@Setter
public class Dishes {
    @Id
    private Integer Did;

    public String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private CookBook cookbook;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;


}