package kr.co.plan.service;

import kr.co.plan.dto.FriendDTO;
import kr.co.plan.entity.Friend;
import kr.co.plan.entity.User;

public interface FriendService {
    public Long request(FriendDTO dto);

    default Friend dtoToEntity(FriendDTO dto) {
    User user_request = User.builder().user_code(dto.getFriend_request()).build();
    User user_response = User.builder().user_code(dto.getFriend_response()).build();
    Friend friend = Friend.builder()
            .fno(dto.getFriend_fno())
            .friend_request(user_request)
            .friend_response(user_response)
            .friend_status(dto.getFriend_status()).build();
    return friend;
    }

    default FriendDTO entityToDTO(Friend friend, User user_request, User user_response) {
        FriendDTO dto = FriendDTO.builder()
                .friend_fno(friend.getFno())
                .friend_request(user_request.getUser_code())
                .friend_response(user_response.getUser_code())
                .friend_status(friend.getFriend_status())
                .regDate(friend.getRegDate())
                .modDate(friend.getModDate())
                .build();
        return dto;
    }


}
