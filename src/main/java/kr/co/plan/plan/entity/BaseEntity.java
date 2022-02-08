package kr.co.plan.plan.entity;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name = "reddate", updatable = false)
    private LocalDateTime regDate;

    @CreatedDate
    @Column(name = "modDate", updatable = true)
    private LocalDateTime modDate;


}
