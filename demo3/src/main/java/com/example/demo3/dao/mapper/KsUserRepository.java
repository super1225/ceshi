package com.example.demo3.dao.mapper;


import com.example.demo3.dao.bean.KsUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface KsUserRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from ks_user where user_id = ${user_id}")
    KsUser getUserById(@Param("user_id") int user_id);

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


