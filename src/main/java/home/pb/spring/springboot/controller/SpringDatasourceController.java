package home.pb.spring.springboot.controller;

import home.pb.spring.springboot.properties.SpringDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringDatasourceController {

    @Autowired
    private SpringDatasource dataSource;

    @RequestMapping(value = "/datasource")
    public SpringDatasource dataSource(){
        return dataSource;
    }

}
