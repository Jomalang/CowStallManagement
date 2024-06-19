package miniPrj.CowStallManagement.repositroy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miniPrj.CowStallManagement.Form.CowForm;
import miniPrj.CowStallManagement.domain.Cow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CowRepository {

    @PersistenceContext
    private EntityManager em;

    //등록
    public void save(Cow cow){
        em.persist(cow);
    }
    //ID 단건 조회
    public Cow findOne(long id){
        return em.find(Cow.class, id);
    }
    //전체 조회
    public List<Cow> findAll (){
        return em.createQuery("select c from Cow c", Cow.class)
                .getResultList();
    }
    //이표번호 조회
    //정규식으로 뒤의 다섯자리 통해서만으로도 찾을 수 있게 수정해야 함
    //이표번호 조회시 getResultList()사용할지, getSingleResult사용할지.. 골라야함
    public Cow findByCouponId(int couponId){
        String jpql = "select c from Cow c where c.couponId = :couponId";
        return em.createQuery(jpql, Cow.class).setParameter("couponId", couponId)
                .getSingleResult();
    }

    //삭제
    //이게 최선일까?
    public void deleteCow(long Id){
        Cow cowFoundById = em.find(Cow.class, Id);
        em.remove(cowFoundById);
    }

//  이표번호 통해 찾고 수정, 근데 이게 리포지에 필요할까?
    public Cow updateCow(Cow cow, CowForm cowForm) {
        //Id 제외 변경감지 시킨다.
        cow.setCouponId(cowForm.getCouponId());
        cow.setScheduledChildbirthDate(cowForm.getScheduledChildbirthDate());
        cow.setCowBirthDate(cowForm.getCowBirthDate());
        cow.setLocation(cowForm.getLocation());
        cow.setCalf(cowForm.getCalf());
        em.persist(cow);
        return cow;
    }

}
