package home.pb.spring.springboot.mapper;

import home.pb.spring.springboot.entity.TCustomer;
import home.pb.spring.springboot.entity.TCustomerExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TCustomerMapper {
    @SelectProvider(type=TCustomerSqlProvider.class, method="countByExample")
    long countByExample(TCustomerExample example);

    @DeleteProvider(type=TCustomerSqlProvider.class, method="deleteByExample")
    int deleteByExample(TCustomerExample example);

    @Delete({
        "delete from t_customer",
        "where customerId = #{customer_id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long customer_id);

    @Insert({
        "insert into t_customer (customerId, address, ",
        "city, contactName, ",
        "creditLimit, customer_name, ",
        "phone, province, ",
        "saleEmployeeId, createDate)",
        "values (#{customer_id,jdbcType=BIGINT}, #{address,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{contact_name,jdbcType=VARCHAR}, ",
        "#{credit_limit,jdbcType=BIGINT}, #{customer_name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{sale_employee_id,jdbcType=BIGINT}, #{createdate,jdbcType=TIMESTAMP})"
    })
    int insert(TCustomer record);

    @InsertProvider(type=TCustomerSqlProvider.class, method="insertSelective")
    int insertSelective(TCustomer record);

    @SelectProvider(type=TCustomerSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="customerId", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contactName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creditLimit", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="customer_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="saleEmployeeId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="createDate", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<TCustomer> selectByExample(TCustomerExample example);

    @Select({
        "select",
        "customerId, address, city, contactName, creditLimit, customer_name, phone, province, ",
        "saleEmployeeId, createDate",
        "from t_customer",
        "where customerId = #{customer_id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="customerId", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contactName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creditLimit", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="customer_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="saleEmployeeId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="createDate", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    TCustomer selectByPrimaryKey(Long customer_id);

    @UpdateProvider(type=TCustomerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    @UpdateProvider(type=TCustomerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    @UpdateProvider(type=TCustomerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TCustomer record);

    @Update({
        "update t_customer",
        "set address = #{address,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "contactName = #{contact_name,jdbcType=VARCHAR},",
          "creditLimit = #{credit_limit,jdbcType=BIGINT},",
          "customer_name = #{customer_name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "saleEmployeeId = #{sale_employee_id,jdbcType=BIGINT},",
          "createDate = #{createdate,jdbcType=TIMESTAMP}",
        "where customerId = #{customer_id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TCustomer record);
}