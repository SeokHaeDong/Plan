package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.FriendDTO;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.Friend;
import kr.co.plan.plan.entity.User;

public interface FriendService {
    // userDTO에서 받아 오는 값은 세션 파트가 추가 되면 UserDTO에서 값을 받아 오는것이 아니라 session에 있는 값을 대입한다
    default Friend DTOToEntity(UserDTO userDTO, FriendDTO friendDTO){
        User user = User.builder().code(userDTO.getCode()).build();
        User response_user = User.builder().code(friendDTO.getResponse_u()).build();
        Friend friend = Friend.builder().fno(friendDTO.getFno()).request_u(user).response_u(response_user).status(friendDTO.getStatus()).build();
        return friend;
    }

    default FriendDTO EntityToDTO(User user,Friend friend){
        // 이상함 뭔가 잘못 된것 같은 느낌
        // request_u, response_u 에 long 타입으로 유저의 코드가 들어가야 하긴하는데
        // user.getCode를 하게 된다면 값은 값을 불러 오는거 아닌지??

        // response_u 의 값은 무조건 friend 테이블의 값을 가져와서 대입 해 주어야만 친구의 코드가 정상적으로 들어간다

        // 값이 정상적으로 나와??
        Object object = friend.getResponse_u();
        long object1 = (long) object;


        FriendDTO friendDTO = FriendDTO.builder().fno(friend.getFno()).request_u(user.getCode()).response_u(object1).status(friend.getStatus()).modDate(friend.getModDate()).regDate(friend.getRegDate()).build();

        return friendDTO;
    }


}
