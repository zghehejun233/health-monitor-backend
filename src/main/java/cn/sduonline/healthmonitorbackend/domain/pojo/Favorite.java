package cn.sduonline.healthmonitorbackend.domain.pojo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created By Tian Shucheng on 2022/7/17 18:34
 */
@Entity
@Table(name = "favorite",
        uniqueConstraints = {
        })
@Getter
@Setter
public class Favorite {
    @Id
    private Integer fid;//id
    @NotNull
    private int cid;//菜谱id
    @NotNull
    private String cname;//名称
    @NotNull
    private double health_score;//健康指数


}