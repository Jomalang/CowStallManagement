package miniPrj.CowStallManagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

}
