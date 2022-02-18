package kr.co.plan.plan;


import kr.co.plan.plan.dto.FriendDTO;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.Friend;
import kr.co.plan.plan.entity.Question;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.FriendRepository;
import kr.co.plan.plan.repository.QuestionRepository;
import kr.co.plan.plan.repository.UserRepository;
import kr.co.plan.plan.service.FriendService;
import kr.co.plan.plan.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.parameters.P;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FriendRepository friendRepository;


    // User 정보를 랜덤으로 100 까지 삽입 하는 메서드
    //@Test
    public void userRegisterTest(){
        IntStream.rangeClosed(1, 100).forEach( i -> {
            int length = 10;
            String str = RandomStringUtils.randomAlphanumeric(length);
            String str_id = RandomStringUtils.randomAlphanumeric(length);
            String str_pw = RandomStringUtils.randomAlphanumeric(length);
            String str_nick = RandomStringUtils.randomAlphanumeric(length);

            int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int iMinMonth = 1;
            int iMaxMonth = 12;

            int iRandomYear = RandomUtils.nextInt(1970, 2021);
            int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
            int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);

            String[] rgender = {"M" ,"F"};
            Random rd = new Random();

            String str_date = iRandomYear + "-" + ((iRandomMonth / 2 < 5 ) ? "0"+iRandomMonth : iRandomMonth) + "-" + ((iRandomDay / 2 < 5) ? "0"+iRandomDay : iRandomDay);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.KOREA);

            LocalDate date = LocalDate.parse(str_date, formatter);

            User user = User.builder().email(str + "@gmail.com").id(str_id).pw(str_pw).nick(str_nick).birthday(date).gender(rgender[rd.nextInt(2)]).build();
            userRepository.save(user);
        });
    }

//    @Test
    public void questionInsertTest(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            int length = 10;
            String question_context = RandomStringUtils.randomAlphanumeric(length);

            Question question = Question.builder().context(question_context).build();

            questionRepository.save(question);
        });
    }

//    @Test
    public void friendRepositoryTest(){

        LongStream.rangeClosed(1, 10).forEach(i -> {
            // session에서 받아온 로그인 된 유저정보중에 code 사용
            User user = User.builder().code(i).build();
            // 친구 요청을 받을 친구의 code 로그인한 유저가 입력한 유저의 코드를 찾아와서 대입
            User user1 = User.builder().code(1L).build();
            Friend friend = Friend.builder().request_u(user).response_u(user1).build();
            //일단은 Repository 부터 정상작동 하는지 테스트
            friendRepository.save(friend);

        });
    }



//    @Test
    public void friendRequestStatusUpdate(){

        User response_user = User.builder().code(1L).build();

        User request_user = User.builder().code(4L).build();

        // 클라이언트에서 서비스로 넘어와서 DTOToEntity 변환을 거쳐서 값이 전달
        // 수락을 했을 경우 request에 값을 전부 담아 넘기므로 request.getAttribute를 통해서 바로 repo 에 값 전달 가능

        friendRepository.requestAccept("수락", request_user ,response_user);

    }

//    @Test
//    @Transactional
    public void myFriendRequestList(){
        User code = User.builder().code(1L).build();

        User response_user = User.builder().code(1L).build();

        List<String> list = friendRepository.requestFriendAdd(1L);

        for (String result : list){
            System.out.println(result);
        }
    }

//    @Test
//    @Transactional
    public void myFriendList(){

        List<String> list = friendRepository.friendList(1L);

        for (String result : list){
            System.out.println(result);
        }

    }




}
