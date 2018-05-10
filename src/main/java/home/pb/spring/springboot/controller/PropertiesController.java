package home.pb.spring.springboot.controller;

import home.pb.spring.springboot.properties.Email2Properties;
import home.pb.spring.springboot.properties.EmailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private EmailProperties emailProperties;

    @Autowired
    private Email2Properties email2Properties;

    @RequestMapping(value = "/emailProperties")
    public EmailProperties properties(){
        return emailProperties;
    }

    @RequestMapping(value = "/email2Properties")
    public Email2Properties getEmail2Properties() {
        return email2Properties;
    }
}
