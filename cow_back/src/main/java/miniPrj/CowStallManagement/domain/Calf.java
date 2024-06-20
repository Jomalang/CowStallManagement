package miniPrj.CowStallManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Calf {
    @Id
    @GeneratedValue
    @Column(name = "CALF_ID")
    private int id;

    private String calf_sex;

    private LocalDate childbirth_date;

    //일대일 종
    //지연로딩
    //캐스캐이딩
    @OneToOne(mappedBy = "calf", fetch = LAZY, cascade = CascadeType.ALL)
    private Cow cow;

}
