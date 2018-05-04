package home.pb.spring.springboot.controller;

import home.pb.spring.springboot.entity.Customer;
import home.pb.spring.springboot.respository.CustomerDao;
import home.pb.spring.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/save")
    public String save(){

        Customer customer = new Customer();
        customer.setCustomerName("sansan");
        customer.setAddress("diqiu");
        customer.setCity("chengshi");
        customer.setProvince("shengfeng");
        customer.setContactName("ererer");
        customer.setPhone("12344335544");
        customer.setSaleEmployeeId(1001);
        customer.setCreditLimit(10001);
        service.save(customer);
        return "save ok";
    }

    @RequestMapping(value = "/findAll")
    public Iterable<Customer> findAll(){
        return service.findAll();
    }
    @RequestMapping(value = "/delete")
    public String deleteById(Long id){

        service.deleteById(id);
        return "delete ok";
    }
    @RequestMapping(value = "/findCustomerByCustomerName")
    public Customer findCustomerByCustomerName(String customer_name){
        return customerDao.getCustomerByCustomerName(customer_name);
    }
}
