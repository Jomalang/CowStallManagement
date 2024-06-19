package miniPrj.CowStallManagement;

import jakarta.persistence.EntityManager;
import miniPrj.CowStallManagement.Form.CowForm;
import miniPrj.CowStallManagement.domain.Cow;
import miniPrj.CowStallManagement.repositroy.CowRepository;
import miniPrj.CowStallManagement.service.CowService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class CowServiceTest {

    static LocalDate date = LocalDate.now(); //테스트용 날짜

    @Autowired
    EntityManager em;
    @Autowired
    CowRepository cowRepository;
    @Autowired
    CowService cowService;

    @Test
    public void 어미소등록() throws Exception{
        //given
        Cow cow1 = getCow(123456789);
        //when
        Long savedId = cowService.join(cow1);

        //then
        assertThat(savedId).isEqualTo(cow1.getId());
    }
    @Test
    public void 어미소ID조회() {
        //given
        Cow cow = getCow(123456789);
        long joinId = cowService.join(cow);

        // when
        Cow CowfoundById = cowService.findById(joinId);

        // then
        assertThat(joinId).isEqualTo(CowfoundById.getId());
     }

     @Test
     public void 어미소이표번호조회() {
         //given
        int couponId = 112233445; //9자리
        Cow cow = getCow(couponId);
        em.persist(cow); //등록
         // when

        Cow cowByCouponId = cowService.findByCouponId(couponId);
        long CowId = cowByCouponId.getId();

         // then
         assertThat(CowId).isEqualTo(cow.getId());
      }

      @Test
      public void 어미소전체조회() {
          //given
         Cow cow1 = getCow(123456789);
         Cow cow2 = getCow(987654321);
         Cow cow3 = getCow(135792468);
         cowService.join(cow1);
         cowService.join(cow2);
         cowService.join(cow3);

          // when
          List<Cow> allCows = cowService.findAllCows();

          // then
          assertThat(allCows.size()).isEqualTo(3);
          assertThat(allCows.contains(cow1)).isEqualTo(true);
          assertThat(allCows.contains(cow2)).isEqualTo(true);
          assertThat(allCows.contains(cow3)).isEqualTo(true);
       }

       @Test
       public void 어미소삭제() {
           //given
           Cow cow1 = getCow(123456789);
           cowService.join(cow1);
           // when
           cowService.deleteCow(cow1);
           try {
               Cow byId = cowService.findById(cow1.getId());
           } catch(Exception e){
               String message = e.getMessage();
               System.out.println(message);
           }

           // then
        }

        @Test
        public void 수정테스트() {
            //given
            Cow cow = getCow(123456789);
            em.persist(cow); //영속화

            // when
            //web단에서 받아온 데이터를 서비스단으로 전송 위한 Form객체
            CowForm cowForm = new CowForm();
            cowForm.setId(cow.getId());
            cowForm.setCouponId(cow.getCouponId());
            //수정된 부분
            cowForm.setCowBirthDate(LocalDate.of(2021, 1, 1));
            //수정된 부분
            cowForm.setScheduledChildbirthDate(LocalDate.of(2021, 1, 1));
            cowForm.setFertileDate(cow.getFertileDate());
            cowForm.setLocation("상");
            //수정된 부분
            cowForm.setCalf(cow.getCalf());
            Cow updatedCow = cowService.ChangeCow(123456789, cowForm);

            // then
            assertThat(updatedCow.getCowBirthDate()).isEqualTo(LocalDate.of(2021,1,1));
            assertThat(updatedCow.getScheduledChildbirthDate()).isEqualTo(LocalDate.of(2021,1,1));
            assertThat(updatedCow.getLocation()).isEqualTo("상");
            //id는 유지되어야 한다.
            assertThat(updatedCow.getId()).isEqualTo(cow.getId());

        }

    private static Cow getCow(int couponId) {
        Cow cow1 = new Cow();
        cow1.setCouponId(couponId);
        cow1.setLocation("하");
        cow1.setCowBirthDate(date);
        cow1.setCowBirthDate(date);
        return cow1;
    }

}