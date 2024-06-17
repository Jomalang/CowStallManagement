package miniPrj.CowStallManagement.repositroy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    public List<Cow> findByCouponId(int couponId){
        String jpql = "select c from Cow where Cow.couponId = couponId";
        return em.createQuery(jpql, Cow.class).setParameter("couponId", couponId)
                .getResultList();
    }

    //수정

    //삭제

}
