package cn.sduonline.healthmonitorbackend.repository;

import cn.sduonline.healthmonitorbackend.domain.pojo.Favorite;
import cn.sduonline.healthmonitorbackend.domain.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By guosurui on 2022/7/17 23:12
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    @Query(value = "select max(fid) from Favorite  ")
    Integer getMaxId();

    @Query(value = "select * from  favorite p where p.cid= ?1", nativeQuery = true)
    public List<Favorite> findByCid(Integer cid);

    @Query(value = "select * from  favorite p where p.cname=?1 ", nativeQuery = true)
    public List<Favorite> findByCname(String cname);
}

