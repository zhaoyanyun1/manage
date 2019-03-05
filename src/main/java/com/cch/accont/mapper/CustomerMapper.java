package com.cch.accont.mapper;

import com.cch.base.dao.BaseMapper;
import com.cch.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer,String> {


}
