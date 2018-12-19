package com.cch.accont.mapper;

import com.cch.base.dao.BaseMapper;
import com.cch.entity.Company;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company,String> {

    /**
     * 根据公司名称获取公司信息
     * @param companyName
     * @return
     */
    @Select("select * from t_company where company_name=#{companyName}")
    @Results({
            @Result(property = "companyName",column = "company_name"),
            @Result(property = "companyTel",column = "company_tel"),
            @Result(property = "companyAddress",column = "company_address"),
    })
    Company getByCompanyName(@Param("companyName") String companyName);

//    /**
//     * 获取用户的角色
//     * @param userId
//     * @return
//     */
//    @Select("select r.* from t_role r,t_user_role ur where r.id=ur.role_id and ur.user_id=#{userId}")
//    List<Role> getRoleList(@Param("userId") String userId);
//
//    /**
//     * 保存用户角色
//     */
//    @Insert({"insert into t_user_role (user_id,role_id) values(#{userId},#{roleId})"})
//    void saveRoles(@Param("userId") String userId, @Param("roleId") Long roleId);
//
//    @Delete("delete from t_user_role where user_id=#{userId}")
//    void deleteRoles(@Param("userId") String userId);

}
