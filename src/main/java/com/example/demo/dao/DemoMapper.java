package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
public interface DemoMapper {
    List<Map> queryUser();
}
