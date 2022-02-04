package com.team.team_project_04feb.repository;

import com.team.team_project_04feb.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    //이메일이나 아이디로 조회하기
    @EntityGraph(attributePaths = {"roleSet"},type = EntityGraph.EntityGraphType.LOAD)
    @Query("select u from User u where u.email=:id or u.id=:id")
    Optional<User> findById(String id);
}
