package cn.sduonline.healthmonitorbackend.repository;

import cn.sduonline.healthmonitorbackend.domain.pojo.CookBook;
import cn.sduonline.healthmonitorbackend.domain.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created By guosurui on 2022/7/17 23:10
 */
@Repository
public interface CookBookRepository extends JpaRepository<CookBook, Integer> {
    @Query(value = "select max(cid) from CookBook  ")
    Integer getMaxId();
    @Query(value = "select * from  cookbook p where p.cid= ?1", nativeQuery = true)
    public List<CookBook> findByCid(Integer cid);
}
