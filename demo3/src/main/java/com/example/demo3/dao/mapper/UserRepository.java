package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface UserRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);
    @Select("select * from user where name = #{name}")
    User getUserByName(@Param("name") String name);

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


