package kr.co.plan.service;

import kr.co.plan.dto.FriendDTO;
import kr.co.plan.entity.Friend;
import kr.co.plan.entity.User;

public interface FriendService {
    public Long request(FriendDTO dto);

    default Friend dtoToEntity(FriendDTO dto) {
        User request = User.builder().code(dto.getRequest()).build();
        User response = User.builder().code(dto.getResponse()).build();
        Friend friend = Friend.builder()
                .fno(dto.getFno())
                .request(request)
                .response(response)
                .status(dto.getStatus()).build();
        return friend;
    }

    default FriendDTO entityToDTO(Friend friend, User request, User response) {
        FriendDTO dto = FriendDTO.builder()
                .fno(friend.getFno())
                .request(request.getCode())
                .response(response.getCode())
                .status(friend.getStatus())
                .regDate(friend.getRegDate())
                .modDate(friend.getModDate()).build();
        return dto;
    }
}
