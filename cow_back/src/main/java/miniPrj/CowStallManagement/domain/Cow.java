package miniPrj.CowStallManagement.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Cow {

    //팩터리 메서드
    public Cow createCow(int couponId, LocalDate cowBirthDate,
                         @Nullable LocalDate fertileDate,
                         @Nullable LocalDate scheduledChildbirthDate,
                         String location){
        Cow cow = new Cow();
        cow.setCouponId(couponId);
        cow.setCowBirthDate(cowBirthDate);
        cow.setFertileDate(fertileDate);
        cow.setScheduledChildbirthDate(scheduledChildbirthDate);
        cow.setLocation(location);

        return cow;
    }

    @Id
    @GeneratedValue
    @Column(name = "COW_ID")
    private long id; //아이디

    //생성시 아홉자리 검증로직 필요함.
    private int couponId; //이표번호

    private LocalDate cowBirthDate; //산차

    @Column(nullable = true)
    private LocalDate fertileDate = LocalDate.of(2024,06,19); //수정일 기본값

    @Column(nullable = true)
    private LocalDate scheduledChildbirthDate = LocalDate.of(2024,06,19); //분만 예정일 기본값

    private String location; //위치

    //일대일 주인
    //ToOne은 반드시 수동으로 지연로딩 설정해 줘야 한다.
    //일대일 캐스케이딩
    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name ="CALF_ID", nullable = true)
    private Calf calf; // 기본값

    //일대다(메모)
    @OneToMany(mappedBy = "cow")
    private List<Memo> memos = new ArrayList<>();
}
