package home.pb.spring.springboot.controller;

import home.pb.spring.springboot.entity.Customer;
import home.pb.spring.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/templates")
public class TemplatesController {
    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/hello")
    public String hello(Map<String,String> map, Customer customer){

        map.put("name","SanSan");
        customer.setCustomerName("SanSan");
        customer.setCreateDate(new Date());
        customer.setCreditLimit(445566887);
        return "hello";
    }


}
