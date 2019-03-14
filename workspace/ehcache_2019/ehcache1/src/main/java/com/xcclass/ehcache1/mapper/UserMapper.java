package com.xcclass.ehcache1.mapper;

import com.xcclass.ehcache1.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT ID ,NAME,AGE FROM user where id=#{id}")
    User getUser(@Param("id") Long id);
}
