package home.pb.spring.springboot.service;

import home.pb.spring.springboot.entity.Customer;
import home.pb.spring.springboot.entity.TCustomerExample;
import home.pb.spring.springboot.mapper.TCustomerMapper;
import home.pb.spring.springboot.respository.CustomerDao;
import home.pb.spring.springboot.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private CustomerDao customerDao;

    public Customer save(Customer customer) {
        return customerRespository.save(customer);
    }

    public Iterable<Customer> findAll() {
        return customerRespository.findAll();
    }

    public void deleteById(Long id) {
        customerRespository.deleteById(id);
    }

    public Customer findCustomerByCustomerName(String customer_name) {
        return customerDao.getCustomerByCustomerName(customer_name);
    }

}
