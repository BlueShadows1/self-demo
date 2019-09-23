package com.example.demo.service.impl.oauth2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.oauth2.OAuth2Mapper;
import com.example.demo.dto.oauth2.OAuth2Client;
import com.example.demo.dto.oauth2.OAuth2User;

@Service
public class OAuth2Service {

	@Autowired
    private OAuth2Mapper oauth2Mapper;


    public List<OAuth2Client> getOauth2ClientByClientId(String clientId) {
        return oauth2Mapper.getOauth2ClientByClientId(clientId);
    }

    public List<OAuth2User> getOauth2UserByUsername(String username) {
        return oauth2Mapper.getOauth2UserByUsername(username);
    }
}

