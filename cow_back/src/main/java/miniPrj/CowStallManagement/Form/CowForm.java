package miniPrj.CowStallManagement.Form;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import miniPrj.CowStallManagement.domain.Calf;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Getter @Setter
@RequiredArgsConstructor
public class CowForm {

    private long id; //아이디

    private int couponId; //이표번호

    private LocalDate cowBirthDate; //산차

    private LocalDate fertileDate = LocalDate.of(2024,06,19); //수정일 기본값

    private LocalDate scheduledChildbirthDate = LocalDate.of(2024,06,19); //분만 예정일 기본값

    private String location; //위치

    private Calf calf; // 기본값

    //일대다 주인(메모)
}
