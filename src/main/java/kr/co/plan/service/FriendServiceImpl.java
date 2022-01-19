package kr.co.plan.service;

import kr.co.plan.dto.FriendDTO;
import kr.co.plan.entity.Friend;
import kr.co.plan.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;

    @Override
    public Long request(FriendDTO dto) {
        Friend entity = dtoToEntity(dto);
        friendRepository.save(entity);
        return entity.getFno();
    }
}