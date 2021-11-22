package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Blog;
import com.example.demo3.dao.bean.Case;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface BlogRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from blog where id = #{id}")
    Blog getBlogById(@Param("id") int id);

    @Select("select * from blog where userid = #{userid}")
    List<Blog>  getBlogByuserId(@Param("userid") int userid);

    @Select("select * from blog where 1=1 and (phone=#{phone} or #{phone} IS NULL) and (bankcard=#{bankcard} or #{bankcard} IS NULL)and (website=#{website} or #{website} IS NULL)and (personname_involve like CONCAT(CONCAT('%',#{personname_involve}),'%')  or #{personname_involve} IS NULL)and (victimsname like CONCAT(CONCAT('%',#{victimsname}),'%') or #{victimsname} IS NULL)")
    List<Case> getCasequery(@Param("phone") String phone,@Param("bankcard") String bankcard,@Param("website") String website,@Param("personname_involve") String personname_involve,@Param("victimsname") String victimsname);

    @Select("select * from case_info")
    List<Case> getinfo();

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


