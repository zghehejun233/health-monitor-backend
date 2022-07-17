package cn.sduonline.healthmonitorbackend.repository;
import cn.sduonline.healthmonitorbackend.domain.pojo.Favorite;
import cn.sduonline.healthmonitorbackend.domain.pojo.Ingredient;
import cn.sduonline.healthmonitorbackend.domain.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Created By guosurui on 2022/7/17 23:13
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from  user p where p.username= ?1 and p.password= ?2", nativeQuery = true)
    public List<User> findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from  user p where p.uid= ?1 ", nativeQuery = true)
    public List<User> findByUid(Integer uid);

}
