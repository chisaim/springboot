package home.pb.spring.springboot.lombok.controller;

import home.pb.spring.springboot.lombok.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/girl")
public class GirlController {

    @RequestMapping("/get")
    public Girl  get(){
        Girl girl = new Girl();
        girl.setId(1);
        girl.setAge(20);
        girl.setName("sansan");
        girl.setWeight(20);
        System.out.println(girl);
        return girl;
    }
}
