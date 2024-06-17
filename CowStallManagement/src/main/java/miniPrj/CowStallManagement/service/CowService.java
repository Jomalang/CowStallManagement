package miniPrj.CowStallManagement.service;

import lombok.RequiredArgsConstructor;
import miniPrj.CowStallManagement.domain.Cow;
import miniPrj.CowStallManagement.repositroy.CowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //서비스 계층의 메서드들은 트랜잭션 내에서 이뤄진다
@RequiredArgsConstructor //final이 붙은 필드 갖고 생성자 생성
public class CowService {

    @Autowired
    private final CowRepository cowRepository;

    //등록
    //등록시 검증 메서드 필요
    public long join(Cow cow){
        cowRepository.save(cow);
        return cow.getId(); //getter로 접근하는게 좋다.
    }

    //검증

    //소 전체 조회
    @Transactional(readOnly = true) //성능 최적화
    public List<Cow> findCows() {
        return cowRepository.findAll();
    }

    //소 ID단건 조회
    @Transactional(readOnly = true)
    public Cow findOne(Long cowId){
        return cowRepository.findOne(cowId);
    }


    // 소 이표번호 조회
    @Transactional(readOnly = true)
    public List<Cow> findByCouponId(int couponId){
        return cowRepository.findByCouponId(couponId);
    }
}
