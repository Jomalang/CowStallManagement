package miniPrj.CowStallManagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import miniPrj.CowStallManagement.Form.CowForm;
import miniPrj.CowStallManagement.Form.CowList;
import miniPrj.CowStallManagement.domain.Cow;
import miniPrj.CowStallManagement.repositroy.CowRepository;
import miniPrj.CowStallManagement.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CowController {

    @Autowired
    CowRepository cowRepository;
    @Autowired
    CowService cowService;
    @Autowired
    ObjectMapper objectMapper;

    //소 생성
    @PostMapping("/cow/create")
    public long addCow(@RequestBody CowForm cowForm) {
        Cow cow = createCow(cowForm);
        cowService.join(cow);
        return cow.getId();
    }



    //전체 간략한 리스트 반환
    @ResponseBody
    @PostMapping("/")
    public List<CowList> listCow(){
        List<Cow> allCows = cowService.findAllCows();
        List<CowList> allCowList = new ArrayList<>();

        for(Cow cow : allCows){
            CowList cowlist = new CowList();
            cowlist.setCouponId(cow.getCouponId());
            cowlist.setLocation(cow.getLocation());
            cowlist.setScheduledChildbirthDate(cow.getScheduledChildbirthDate());
            allCowList.add(cowlist);
        }
        return allCowList;
    }

    //상세 페이지 출력
    //GET매핑, 파라미터에 ID받음
    //파라미터 키: cow_id
    @ResponseBody
    @GetMapping("/cow/detail/{cow_id}")
    public CowForm cowForm(@PathVariable("cow_id") long id) {
        Cow cowById = cowService.findById(id);
        CowForm cowForm = createCowForm(cowById);
        //JSON 반환
        return cowForm;
    }

    //소 수정
    @PostMapping("/cow/update/{cow_id}")
    public long updateCow(@PathVariable("cow_id") long id, @RequestBody CowForm cowForm){
        cowService.ChangeCow(id, cowForm);
        return id;
    }

    //Form->cow
    private static Cow createCow(CowForm cowForm) {
        Cow cow = new Cow();
        cow.setCouponId(cowForm.getCouponId());
        cow.setCowBirthDate(cowForm.getCowBirthDate());
        cow.setFertileDate(cowForm.getFertileDate());
        cow.setScheduledChildbirthDate(cowForm.getScheduledChildbirthDate());
        cow.setLocation(cowForm.getLocation());
        cow.setCalf(cowForm.getCalf());
        cow.setMemos(cowForm.getMemos());

        return cow;
    }
    //cow->Form
    private static CowForm createCowForm(Cow cow) {
        CowForm cowForm = new CowForm();
        cowForm.setCouponId(cow.getCouponId());
        cowForm.setCowBirthDate(cow.getCowBirthDate());
        cowForm.setFertileDate(cow.getFertileDate());
        cowForm.setScheduledChildbirthDate(cow.getScheduledChildbirthDate());
        cowForm.setLocation(cow.getLocation());
        cowForm.setCalf(cow.getCalf());
        cowForm.setMemos(cow.getMemos());

        return cowForm;
    }

}
