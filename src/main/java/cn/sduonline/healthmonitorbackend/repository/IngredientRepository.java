package cn.sduonline.healthmonitorbackend.repository;

import cn.sduonline.healthmonitorbackend.domain.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By TianShucheng on 2022/7/17 23:08
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query(value = "select max(iid) from Ingredient  ")
    Integer getMaxId();
    @Query(value = "select * from  ingredient p where p.iid= ?1", nativeQuery = true)
    public List<Ingredient> findByIid(Integer iid);
}
