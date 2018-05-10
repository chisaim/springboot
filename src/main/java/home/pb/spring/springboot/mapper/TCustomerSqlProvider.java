package home.pb.spring.springboot.mapper;

import home.pb.spring.springboot.entity.TCustomer;
import home.pb.spring.springboot.entity.TCustomerExample.Criteria;
import home.pb.spring.springboot.entity.TCustomerExample.Criterion;
import home.pb.spring.springboot.entity.TCustomerExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TCustomerSqlProvider {

    public String countByExample(TCustomerExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_customer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TCustomerExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_customer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TCustomer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_customer");
        
        if (record.getCustomer_id() != null) {
            sql.VALUES("customerId", "#{customer_id,jdbcType=BIGINT}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_name() != null) {
            sql.VALUES("contactName", "#{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit_limit() != null) {
            sql.VALUES("creditLimit", "#{credit_limit,jdbcType=BIGINT}");
        }
        
        if (record.getCustomer_name() != null) {
            sql.VALUES("customer_name", "#{customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.VALUES("province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getSale_employee_id() != null) {
            sql.VALUES("saleEmployeeId", "#{sale_employee_id,jdbcType=BIGINT}");
        }
        
        if (record.getCreatedate() != null) {
            sql.VALUES("createDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TCustomerExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("customerId");
        } else {
            sql.SELECT("customerId");
        }
        sql.SELECT("address");
        sql.SELECT("city");
        sql.SELECT("contactName");
        sql.SELECT("creditLimit");
        sql.SELECT("customer_name");
        sql.SELECT("phone");
        sql.SELECT("province");
        sql.SELECT("saleEmployeeId");
        sql.SELECT("createDate");
        sql.FROM("t_customer");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TCustomer record = (TCustomer) parameter.get("record");
        TCustomerExample example = (TCustomerExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_customer");
        
        if (record.getCustomer_id() != null) {
            sql.SET("customerId = #{record.customer_id,jdbcType=BIGINT}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_name() != null) {
            sql.SET("contactName = #{record.contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit_limit() != null) {
            sql.SET("creditLimit = #{record.credit_limit,jdbcType=BIGINT}");
        }
        
        if (record.getCustomer_name() != null) {
            sql.SET("customer_name = #{record.customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        }
        
        if (record.getSale_employee_id() != null) {
            sql.SET("saleEmployeeId = #{record.sale_employee_id,jdbcType=BIGINT}");
        }
        
        if (record.getCreatedate() != null) {
            sql.SET("createDate = #{record.createdate,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_customer");
        
        sql.SET("customerId = #{record.customer_id,jdbcType=BIGINT}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        sql.SET("contactName = #{record.contact_name,jdbcType=VARCHAR}");
        sql.SET("creditLimit = #{record.credit_limit,jdbcType=BIGINT}");
        sql.SET("customer_name = #{record.customer_name,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        sql.SET("saleEmployeeId = #{record.sale_employee_id,jdbcType=BIGINT}");
        sql.SET("createDate = #{record.createdate,jdbcType=TIMESTAMP}");
        
        TCustomerExample example = (TCustomerExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TCustomer record) {
        SQL sql = new SQL();
        sql.UPDATE("t_customer");
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_name() != null) {
            sql.SET("contactName = #{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit_limit() != null) {
            sql.SET("creditLimit = #{credit_limit,jdbcType=BIGINT}");
        }
        
        if (record.getCustomer_name() != null) {
            sql.SET("customer_name = #{customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getSale_employee_id() != null) {
            sql.SET("saleEmployeeId = #{sale_employee_id,jdbcType=BIGINT}");
        }
        
        if (record.getCreatedate() != null) {
            sql.SET("createDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("customerId = #{customer_id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TCustomerExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}