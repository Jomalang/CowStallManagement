package miniPrj.CowStallManagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Cow {
    @Id
    @GeneratedValue
    private long id; //아이디

    private int couponId; //이표번호

    private LocalDate cowBirthDate; //산차

    private LocalDate fertileDate; //수정일

    private LocalDate scheduledChildbirthDate; //분만 예정일

    private String location; //위치
}
