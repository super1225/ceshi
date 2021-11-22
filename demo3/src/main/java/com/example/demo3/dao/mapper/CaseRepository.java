package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.Rela_Case_info;
import com.example.demo3.dao.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface CaseRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from case_info where id = #{id}")
    Case getCaseById(@Param("id") int id);

    @Select("select count(*) from case_info where place like CONCAT(CONCAT('%',#{place}),'%')")
    Integer getCaseByplace(@Param("place") String place);

    @Select("select count(*) from case_info where type = #{type} and time between #{defaultStartDate} and #{defaultEndDate}")
    Integer getrecentCaseBytime(@Param("defaultStartDate") String defaultStartDate,@Param("defaultEndDate") String defaultEndDate,@Param("type") String type);

    @Select("select count(*) from case_info where import_time between '${defaultStartDate}' and '${defaultEndDate}'")
    Integer getrecentimportinfoBytime(@Param("defaultStartDate") String defaultStartDate,@Param("defaultEndDate") String defaultEndDate);

    @Select("select id from case_info where personid_involve like CONCAT(CONCAT('%,',#{userid}),',%') or (victims like CONCAT(CONCAT('%,',#{userid}),',%'))")
    List<Integer> getcaseinfobyuserid(String userid);

    @Select("select * from case_info where 1=1 and (phone=#{phone} or #{phone} IS NULL) and (bankcard=#{bankcard} or #{bankcard} IS NULL)and (website=#{website} or #{website} IS NULL)and (personname_involve like CONCAT(CONCAT('%',#{personname_involve}),'%')  or #{personname_involve} IS NULL)and (victimsname like CONCAT(CONCAT('%',#{victimsname}),'%') or #{victimsname} IS NULL)")
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


