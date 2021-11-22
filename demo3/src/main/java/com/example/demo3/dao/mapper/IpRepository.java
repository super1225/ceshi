package com.example.demo3.dao.mapper;
import com.example.demo3.dao.bean.Blog;
import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.IP;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//import org.graalvm.compiler.replacements.SnippetTemplate;

@Service
@CrossOrigin

public interface IpRepository {
    
    //根据用户id确认用户信息-ok
    @Select("select * from ip")
    List<IP> getIP();

    @Insert("insert into ip(ip,url) values(#{ip},#{url})")
    void addIP(String ip,String url);

    @Update("update ks_tokens set token = #{token} where user_id = ${userId}")
    void updateToken(int userId,String token);



}


