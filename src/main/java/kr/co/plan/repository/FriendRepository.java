package kr.co.plan.repository;

import kr.co.plan.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FriendRepository extends JpaRepository<Friend, Long> {
   //@Query("select Friend, Friend.friend_request from Friend left join Friend.friend_request where Friend.fno = :fno")
    //Object getFriendByRequest(@Param("fno") Long fno);
}
