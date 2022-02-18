package kr.co.plan.plan.repository;

import kr.co.plan.plan.entity.Question;
import kr.co.plan.plan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{

    //  중복 검사를 위한 메서드
    @Query("select u.email, u.id, u.nick, u.pw from User u")
    public List<Object[]> dataList();

    // 유저 정보 수정을 위한 유저 정보 검색
    // 유저 정보 수정에서 수정할 컬럼은 어떤 것들이 존재?? email, id는 고정 나머지 수정 가능
    @Query("select u from User u where u.id = :id")
    public User userInfoUpdate(String id);

    // 유저 회원가입 시 본인 확인질문을 위한 질문 3가지를 Question테이블에서 가져오기
    @Query(value = "select q from Question q order by rand() LIMIT 1", nativeQuery = true)
    public Question userRegisterQuestion();

}
