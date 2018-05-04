package home.pb.spring.springboot.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(columnDefinition = "varchar(100) comment''")
    private String contactName;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String province;

    @Column
    private String city;

    @Column
    private long saleEmployeeId;

    @Column
    private long creditLimit;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getSaleEmployeeId() {
        return saleEmployeeId;
    }

    public void setSaleEmployeeId(long saleEmployeeId) {
        this.saleEmployeeId = saleEmployeeId;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }
}
