package miniPrj.CowStallManagement.service;

import lombok.RequiredArgsConstructor;
import miniPrj.CowStallManagement.Form.CowForm;
import miniPrj.CowStallManagement.domain.Cow;
import miniPrj.CowStallManagement.repositroy.CowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional //서비스 계층의 메서드들은 트랜잭션 내에서 이뤄진다
@RequiredArgsConstructor //final이 붙은 필드 갖고 생성자 생성, 생성자 주입 방식 사용
public class CowService {

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
    public List<Cow> findAllCows() {
        return cowRepository.findAll();
    }

    //소 ID단건 조회
    @Transactional(readOnly = true)
    public Cow findById(Long cowId){
        return cowRepository.findOne(cowId);
    }


    // 소 이표번호 조회
    @Transactional(readOnly = true)
    public Cow findByCouponId(int couponId){
        return cowRepository.findByCouponId(couponId);
    }

    //소 이표번호 통해 삭제
    public void deleteCow(Cow cow){
        cowRepository.deleteCow(cow.getId());
    }

    //소 수정
    public Cow ChangeCow(long id, CowForm cowForm){
        Cow cowFindById = cowRepository.findOne(id);
        cowRepository.updateCow(cowFindById, cowForm);

        return cowFindById;
    }
}
