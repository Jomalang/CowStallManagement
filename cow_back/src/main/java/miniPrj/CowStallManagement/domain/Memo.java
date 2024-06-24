package miniPrj.CowStallManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue
    @Column(name = "MEMO_ID")
    private long id;
    private String content;
    private LocalDate createDate;

    //다대일 주인(다)
    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "COW_ID")
    private Cow cow;

}
