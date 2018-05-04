package home.pb.spring.springboot.respository;

import home.pb.spring.springboot.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends CrudRepository<Customer,Long>{

    Customer save(Customer customer);

    Iterable<Customer> findAll();

    void deleteById(Long id);

}
