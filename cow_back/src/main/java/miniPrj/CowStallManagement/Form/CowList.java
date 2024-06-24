package miniPrj.CowStallManagement.Form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CowList {

    private int couponId;

    private LocalDate scheduledChildbirthDate;

    private String location;
}
