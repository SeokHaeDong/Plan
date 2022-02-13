package kr.co.plan.plan;


import kr.co.plan.plan.entity.Question;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.QuestionRepository;
import kr.co.plan.plan.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // User 정보를 랜덤으로 100 까지 삽입 하는 메서드
//    @Test
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

}
