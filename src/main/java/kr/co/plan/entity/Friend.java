package kr.co.plan.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"friend_request", "friend_response"})
public class Friend extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    private int friend_status;
    @ManyToOne(fetch = FetchType.LAZY)
    private User friend_request;
    @ManyToOne(fetch = FetchType.LAZY)
    private User friend_response;
}

