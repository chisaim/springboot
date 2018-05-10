package home.pb.spring.springboot.entity;

import java.util.Date;

public class TCustomer {
    private Long customer_id;

    private String address;

    private String city;

    private String contact_name;

    private Long credit_limit;

    private String customer_name;

    private String phone;

    private String province;

    private Long sale_employee_id;

    private Date createdate;

    public TCustomer(Long customer_id, String address, String city, String contact_name, Long credit_limit, String customer_name, String phone, String province, Long sale_employee_id, Date createdate) {
        this.customer_id = customer_id;
        this.address = address;
        this.city = city;
        this.contact_name = contact_name;
        this.credit_limit = credit_limit;
        this.customer_name = customer_name;
        this.phone = phone;
        this.province = province;
        this.sale_employee_id = sale_employee_id;
        this.createdate = createdate;
    }

    public TCustomer() {
        super();
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    public Long getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Long credit_limit) {
        this.credit_limit = credit_limit;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name == null ? null : customer_name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public Long getSale_employee_id() {
        return sale_employee_id;
    }

    public void setSale_employee_id(Long sale_employee_id) {
        this.sale_employee_id = sale_employee_id;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}