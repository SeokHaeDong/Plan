package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.User;

import java.util.Map;

public interface UserService {

    /*String getEmail();
    String getId();
    String getNick();*/

    // User DTO 를 User Entity 로 변환해주는 메서드
    default User DTOToEntity(UserDTO dto){
        User user = User.builder().code(dto.getCode()).email(dto.getEmail()).id(dto.getId()).pw(dto.getPw()).nick(dto.getNick()).birthday(dto.getBirthday()).gender(dto.getGender())
                .status(dto.getStatus()).build();


        return user;
    }

    // User Entity 를 User DTO 로 변환 해 주는 메서드
    default UserDTO EntityToDTO(User user){
        UserDTO dto = UserDTO.builder().code(user.getCode()).email(user.getEmail()).id(user.getId()).pw(user.getPw()).nick(user.getNick()).birthday(user.getBirthday()).gender(user.getGender())
                .status(user.getStatus()).regDate(user.getRegDate()).build();

        return dto;
    }

    public Map<String, Object> register(UserDTO dto);


    public Map<String, Object> UserLogin(UserDTO dto);

    public void userModifiy(UserDTO dto);

    public void userRemove(UserDTO dto);


    


}
