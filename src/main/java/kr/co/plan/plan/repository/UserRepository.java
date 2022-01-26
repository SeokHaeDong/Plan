package kr.co.plan.plan.repository;

import kr.co.plan.plan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    // email , id, nick 중복 검사를 위한 메서드
    @Query("select  email from User")
    public List<String> usingCheck();












}
