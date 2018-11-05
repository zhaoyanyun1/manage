package com.cch.accont.mapper;

import com.cch.base.dao.BaseMapper;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Mapper
public interface StockRemovalMapper extends BaseMapper<StockRemoval,String> {

        /**
     * 根据订单号查询所有出库记录
     * @param orderNum
     * @return
     */
    @Select("SELECT * FROM manage.t_stockremoval where order_num=#{orderNum} ")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsType", column = "goods_type"),
            @Result(property = "goodsAllocation", column = "goods_allocation"),
            @Result(property = "goodsNum", column = "goods_num"),
            @Result(property = "despatchMode", column = "despatch_mode"),
            @Result(property = "clientAddress", column = "client_address"),
    })
    List<StockRemoval> listByOrderNum(@Param("orderNum") String orderNum);

//    /**
//     * 根据用户名获取用户
//     * @param goodsName
//     * @return
//     */
//    @Select("select * from t_repertory where goods_name=#{goodsName} and supplier =#{supplier}")
//    @Results({
//            @Result(property = "goodsNum", column = "goods_num"),
//            @Result(property = "goodsName",column = "goods_name"),
//    })
//    Repertory getBygoodsName(@Param("goodsName") String goodsName, @Param("supplier") String supplier);
//    /**
//     * 根据用户名获取用户
//     * @param id
//     * @return
//     */
//    @Select("select * from t_repertory where id=#{id}")
//    @Results({
//            @Result(property = "goodsNum", column = "goods_num"),
//            @Result(property = "goodsName",column = "goods_name"),
//    })
//    Repertory getByid(@Param("id") Long id);
//    /**
//     * 根据用户名获取用户
//     * @param username
//     * @return
//     */
//    @Select("select * from t_user where user_name=#{username} and pass_wd=#{passWd}")
//    @Results({
//            @Result(property = "passWd", column = "pass_wd"),
//            @Result(property = "userName",column = "user_name"),
//    })
//    User getUser(@Param("username") String username, @Param("passWd") String passWd);
//    /**
//     * 根据用户名获取用户
//     * @return
//     */
//    @Select("select * from t_user where state=1")
//    @Results({
//            @Result(property = "passWd", column = "pass_wd"),
//            @Result(property = "userName",column = "user_name"),
//    })
//    List<User> getUserList();

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
