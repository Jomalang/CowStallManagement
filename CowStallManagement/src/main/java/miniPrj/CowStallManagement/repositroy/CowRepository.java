package miniPrj.CowStallManagement.repositroy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miniPrj.CowStallManagement.domain.Cow;
import org.springframework.stereotype.Repository;

@Repository
public class CowRepository {

    @PersistenceContext
    private EntityManager em;

    //등록
    public void save(Cow cow){
        em.persist(cow);
    }

    //이표번호 조회
//    public Cow findByCouponId(int couponId){
//        return em.find(Cow.class )
//    }
}
