package home.pb.spring.springboot.controller;

import home.pb.springboot.calculatespringbootstarter.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @Autowired
    private CalculateService service;

    @GetMapping("/add")
    public double add(double a, double b) {
        return service.add(a,b);
    }
    @GetMapping("/sub")
    public double sub(double a, double b) {
        return service.sub(a,b);
    }
    @GetMapping("/mul")
    public double mul(double a, double b) {
        return service.mul(a,b);
    }
    @GetMapping("/div")
    public double div(double a, double b) {
        return service.div(a,b);
    }
    @GetMapping("/setScale2")
    public double setScale(double a, int scale) {
        //四舍五入
        return service.setScale(a,scale);
    }

    @GetMapping("/setScale")
    public double setScale(double a) {
        //四舍五入
        return service.setScale(a);
    }

}
