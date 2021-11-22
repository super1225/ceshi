package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.Travel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface TravelRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from travel_info where id = #{id}")
    Travel getTravelById(@Param("id") int id);
    @Select("select * from travel_info where userid = #{id}")
    List<Travel> getTravelByUserId(@Param("id") int id);
    @Select("select partnerids from travel_info where userid = #{id}")
    List<Travel> getTravelpartnersById(@Param("id") int id);

    @Select("select * from travel_info")
    List<Travel> getinfo();

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


