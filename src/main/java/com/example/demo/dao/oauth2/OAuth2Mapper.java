package com.example.demo.dao.oauth2;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.example.demo.dto.oauth2.OAuth2Client;
import com.example.demo.dto.oauth2.OAuth2User;

public interface OAuth2Mapper {

    @Select("select * from oauth2_client where clientId = #{clientId} ")
    public List<OAuth2Client> getOauth2ClientByClientId(String clientId);
    @Select("select * from oauth2_user where username = #{username} ")
    public List<OAuth2User> getOauth2UserByUsername(String username);
    
}

