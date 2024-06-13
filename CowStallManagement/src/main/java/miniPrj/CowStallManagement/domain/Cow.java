package miniPrj.CowStallManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Cow {
    @Id
    @GeneratedValue
    @Column(name = "COW_ID")
    private long id; //아이디

    private int couponId; //이표번호

    private LocalDate cowBirthDate; //산차

    private LocalDate fertileDate; //수정일

    private LocalDate scheduledChildbirthDate; //분만 예정일

    private String location; //위치

    //일대일 주인
    //ToOne은 반드시 수동으로 지연로딩 설정해 줘야 한다.
    //일대일 캐스케이딩
    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name ="CALF_ID")
    private Calf calf;



}
