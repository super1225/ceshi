package com.example.demo3.dao.mapper;

import com.example.demo3.dao.bean.Rela_Case_info;
import com.example.demo3.dao.bean.Sim_Case_info;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface Sim_Case_infoRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from similarity")
    List<Sim_Case_info> getinfo();

    @Select("select * from similarity where 1=1 and (caseid1=#{caseid1} or #{caseid1} IS NULL) and (name1=#{name1} or #{name1} IS NULL)and (similarity=#{similarity} or #{similarity} IS NULL)")
    List<Sim_Case_info> getSimiCasequery(@Param("caseid1") String caseid1, @Param("name1") String name1, @Param("similarity") String similarity);


    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


