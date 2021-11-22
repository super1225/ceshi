package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.Rela_Case_info;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface Rela_Case_infoRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from relation_info")
    List<Rela_Case_info> getinfo();

    @Select("select * from relation_info where 1=1 and (caseid1=#{caseid1} or #{caseid1} IS NULL) and (name1=#{name1} or #{name1} IS NULL)and (place1=#{place1} or #{place1} IS NULL)")
    List<Rela_Case_info> getRelaCasequery(@Param("caseid1") String caseid1,@Param("name1") String name1,@Param("place1") String place1);

    @Select("select caseid2 from relation_info where caseid1 = '${caseid1}'")
    List<Integer> getrelainfo(Integer caseid1);



    @Select("select * from relation_info where name1 = '${name}'")
    List<Rela_Case_info> getnamerelainfo(String name);

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


