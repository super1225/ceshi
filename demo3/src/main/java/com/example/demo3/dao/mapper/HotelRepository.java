package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Hotel;
import com.example.demo3.dao.bean.Travel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface HotelRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from hotel_info where id = #{id}")
    Hotel getHotelById(@Param("id") int id);
    @Select("select * from hotel_info where userid = #{id}")
    List<Hotel> getHotelByUserId(@Param("id") int id);
    @Select("select partnerids from hotel_info where userid = #{id}")
    List<Hotel> getHotelpartnersById(@Param("id") int id);

    @Select("select * from hotel_info")
    List<Hotel> getinfo();

    @Delete("delete from ks_tokens where token = '${token}'")
    void deleteToken(String token);

    @Insert("insert into ks_tokens values(#{userId},#{account},#{token})")
    void addToken(int userId,String account,String token);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


