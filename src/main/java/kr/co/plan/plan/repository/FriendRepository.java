package kr.co.plan.plan.repository;

import kr.co.plan.plan.dto.FriendDTO;
import kr.co.plan.plan.entity.Friend;
import kr.co.plan.plan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {


    // 친구 요청 승인, 거절
    // response_u 의 값은 session에서 user의 code를 찾아와서 대입
    // Friend Entity에서 request_u, response_u 를 User 클래스의 형태로 받았기에 값을 넘길 때 도 User 클래스 형태로 넘겨야 함
    @Query(value = "update Friend set status = :status where request_u = :request_u and response_u = :response_u")
    @Modifying
    @Transactional
    public void requestAccept(String status, User request_u, User response_u);

    // 쌍방 요청시 자동으로 status를 수락 으로 만들어주는 메서드 작성
    @Query(value = "update Friend set status case when request = response = :code then status = '수락' end whered response = :response and request = request", nativeQuery = true)
    @Modifying
    @Transactional
    public void autoUpdateMultipleRequest();


    // 친구 목록
    @Query(value = "select u.nick from User u inner join Friend f on f.response = u.code where f.response = :response and f.status = '수락'", nativeQuery = true)
    public List<String> friendList(Long response);


    // 나한테 들어온 친구추가 요청 찾아오기 + 내가 친구에게 보내고 친구도 나에게 친구요청을 했을 경우
    // 1. 한 쪽이 수락 할 시 반대쪽도 자동으로 수락 하는 update 형식으로 구현
    // 전체 데이터 들고 와버림 -> 로그인한 user에 해당하는 code의 값을 session에서 찾아와야 함
    @Query(value = "select u.nick from Friend f inner join User u on f.response = u.code where f.response = :response and f.status = '대기' ", nativeQuery = true)
    public List<String> requestFriendAdd(Long response);



}
