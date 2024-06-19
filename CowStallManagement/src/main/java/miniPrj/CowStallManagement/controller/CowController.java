package miniPrj.CowStallManagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import miniPrj.CowStallManagement.Form.CowForm;
import miniPrj.CowStallManagement.domain.Cow;
import miniPrj.CowStallManagement.repositroy.CowRepository;
import miniPrj.CowStallManagement.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CowController {

    @Autowired
    CowRepository cowRepository;
    @Autowired
    CowService cowService;
    @Autowired
    ObjectMapper objectMapper;

//    @PostMapping("/Cow/save")
//    public String addCow(@RequestBody CowForm cowForm) {
//        Cow cow = new Cow();
//
//
//    }

//    //조회
//    @ResponseBody
//    @GetMapping("/Cow/All")
//    public CowForm

    @ResponseBody
    @GetMapping("/test")
    public String test (){
        return "ok";
    }
}
