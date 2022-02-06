package kr.co.plan.plan.repository;

import kr.co.plan.plan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{

    // email 중복 검사를 위한 메서드
    @Query("select  email from User where email = :email")
    public String emailCheck(String email);

    @Query("select id from User where id = :id")
    public String idCheck(String id);

    @Query("select nick from User where nick = :nick")
    public String nickCheck(String nick);

   /* public boolean existsUserByEmail(String email);

    public boolean existsUserById(String id);

    public boolean existsUserByNick(String nick);*/














}
