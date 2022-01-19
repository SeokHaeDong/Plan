package kr.co.plan.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column(length = 50, nullable = false)
    private String todo_title;

    private String todo_description;

    private String todo_location;
    @Column(nullable = false)
    private LocalDateTime todo_start;

    private LocalDateTime todo_end;

    private String todo_category;

    private String todo_share;

    private int todo_priority;


    @ManyToOne(fetch = FetchType.LAZY)
    private User todo_user;
}

